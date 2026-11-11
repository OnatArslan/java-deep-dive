import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;

public class EnumExample {
    // Her enum sabiti o enumun bir public static final oldugunu soyler

    public enum OrderStatus {
        CREATED("CRT", "Order created"), PAID("PD", "Order paid");

        private final String code;
        private final String description;
        private static final Map<String, OrderStatus> BY_CODE;

        static {
            Map<String, OrderStatus> mp = new HashMap<>();

            for (var value : OrderStatus.values()) {
                mp.put(value.code, value);
            }

            BY_CODE = Map.copyOf(mp);

        }

        private OrderStatus(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

        public boolean isFree() {
            return this.code.equals("PD");
        }

        public static OrderStatus fromCode(String code) {
            OrderStatus status = BY_CODE.get(code);
            if (status == null) {
                throw new IllegalArgumentException("code is not match");
            }
            return status;
        }

    }
}
