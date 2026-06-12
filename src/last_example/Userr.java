package last_example;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Locale;
import java.util.Objects;

public class Userr {
    private String id;
    private String email;
    private int loginCount;
    
    public Userr(String id, String email) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        String rawEmail = Objects.requireNonNull(email, "email cannot be null");
        if (!rawEmail.contains("@")) {
            throw new IllegalArgumentException("email must contain @ got: " + rawEmail);
        }
        
        this.email = rawEmail.trim().toLowerCase(Locale.ROOT);
        
        this.loginCount = 0;
        
    }
    
    public static void main(String[] args) {
        Instant later = Instant.now().plus(Duration.ofMinutes(15));
        System.out.println(later);
        
        BigDecimal newDecimal = new BigDecimal("129.999");
        var newNumber = newDecimal.add(BigDecimal.valueOf(120.88));
        System.out.println(newNumber);
        
        System.out.println(newDecimal);
    }
}
