import javax.swing.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.Clock;

public class InsufficientStockException extends RuntimeException {
    private final String sku;
    private final int requested;
    private final int available;

    public InsufficientStockException(String sku, int requested, int available) {
        super("for item %s requested %d piece but we have only %d".formatted(sku, requested, available));
        this.sku = sku;
        this.requested = requested;
        this.available = available;
    }

    public InsufficientStockException(String sku, int requested, int available, Throwable cause) {
        super("for item %s requested %d piece but we have only %d".formatted(sku, requested, available), cause);
        this.sku = sku;
        this.requested = requested;
        this.available = available;
    }

    public String getSku() {
        return sku;
    }

    public int getRequested() {
        return requested;
    }

    public int getAvailable() {
        return available;
    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= 10; i++) {
            sb.append("---").append("onat").append(" ").append("arslan").append("---").append(";").append("\n");
        }

        System.out.println(sb.toString());

        BigDecimal first = new BigDecimal("19.99");
        var second = new BigDecimal("33.98");

        var total = first.add(new BigDecimal("89.33"));

        BigDecimal result = total.subtract(new BigDecimal("23.33"));
        System.out.println(result);

        BigDecimal zero = new BigDecimal("0.00");

        boolean isZero = zero.compareTo(new BigDecimal("0")) == 0;
        System.out.println(isZero);

        boolean isBigger = second.compareTo(total) > 0;

        boolean isSmaller = second.compareTo(total) < 0;

        boolean isBiggerr = first.compareTo(second) < 0;

        boolean isEqual = first.compareTo(second) == 0;

        System.out.println(isBigger +" " + isSmaller + " "+ isBiggerr);


        BigDecimal bigScale = new BigDecimal("22.99080");

        var scaleTwo = bigScale.setScale(2, RoundingMode.HALF_UP);
        System.out.println(scaleTwo); // 22.99


        BigDecimal divide = new BigDecimal("100").divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);

    }
}
