package last_example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class InvoiceService {
    
    
    String buildSummary(String orderId, List<BigDecimal> lineItems, int discountPercent) {
        Objects.requireNonNull(orderId, "orderId must not be null");
        Objects.requireNonNull(lineItems, "lineItems must not be null");
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException(
                    "discountPercent must be 0..100, got: " + discountPercent);
        }
        
        BigDecimal subtotal = calculateSubtotal(lineItems);
        BigDecimal discount = calculateDiscount(subtotal, discountPercent);
        BigDecimal total = subtotal.subtract(discount);
        
        return "Order " + orderId + " | subtotal=" + subtotal
                + " | discount=" + discount + " | total=" + total;
    }
    
    private static BigDecimal calculateSubtotal(List<BigDecimal> lineItems) {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (BigDecimal item : lineItems) {
            subtotal = subtotal.add(item);
        }
        return subtotal;
    }
    
    private static BigDecimal calculateDiscount(BigDecimal subtotal, int discountPercent) {
        return subtotal
                .multiply(BigDecimal.valueOf(discountPercent))
                .divide(BigDecimal.valueOf(100));
    }
    
}