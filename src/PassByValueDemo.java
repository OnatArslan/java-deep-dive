import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PassByValueDemo {

    private static final String VALUE = "HELLO";

    static void reassign(List<String> tags) {
        tags = new ArrayList<>();  // yalnızca lokal kopya yeni nesneye döndü, çağıranınki aynı kaldı

        tags.add("New Tag");
    }

    static void mutate(List<String> tags) {
        tags.add("Other Tag");
    }


    public static void main(String[] args) {
        List<String> tags = new ArrayList<>(List.of("billing"));
        reassign(tags); // this wont change the original
        System.out.println(tags);   // [billing]
        mutate(tags); // this will change the original
        System.out.println(tags);   // [billing, urgent]

        // Integer cache tuzagi
        Integer a = 127, b = 127;
        System.out.println(a == b);   // true: ikisi de cache'teki aynı nesne

        Integer c = 128, d = 128;
        System.out.println(c == d);   // false: iki ayrı nesne

        System.out.println(Objects.equals(c, d));

        // for long and int we can use Object.equals() method but
        // for bigdecimal

        BigDecimal first = new BigDecimal("199.90");
        BigDecimal second = new BigDecimal("199.9");

        System.out.println(Objects.equals(first, second)); // false

        System.out.println(first.compareTo(second) == 0);

        String label = getLabel(OrderStatus.CANCELLED);

        System.out.println(label);
    }

    // string equals example
    public boolean checkStringEq(String value) {
        if (value.equals("HELLO")) return true; // value null ise npe

        if("Hello".equals(value)) return true; // null safe

        if(Objects.equals(value, "HELLO")) return true; // null safe

        return false;
    }

    // Example of modern switch statement
    public static String getLabel(OrderStatus status) {

        if (status == null) {
            return "Unknown status";
        }

        return switch (status.getValue()) {
            case "pending" -> status.getDescription();
            case "onway" -> status.getDescription();
            case "cancelled" -> status.getDescription();
            default -> "Unknown";
        };
    }


    public enum OrderStatus {
        PENDING("pending", "order on the way"),
        ONWAY("onway", "on the way"),
        CANCELLED("cancelled", "order cancelled")
        ;


        private static final String PREFIX = "OS-";
        private String value;
        private String description;



        OrderStatus(String value, String description) {
            this.value = value;
            this.description = description;
        }

        public String getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }
    }


}
