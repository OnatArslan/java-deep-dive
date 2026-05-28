package example;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ValuePrimitive {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static void main(String[] args) {


        System.out.println(stripString("    onat is goddamn good   "));

        BigDecimal a = new BigDecimal("12.99");
        BigDecimal b = new BigDecimal("119.94");

        System.out.println(b.compareTo(a));

        String rawUuid = "550e8400-e29b-41d4-a716-446655440000";
        String invalidUuid = "not-a-uuid";





        UUID uuidV7 = uuidV7();

        System.out.println(uuidV7);
        System.out.println(uuidV7.version());
        System.out.println(uuidV7.variant());

    }


    static String stripString(String raw) {

        String normalized = Objects.requireNonNull(raw, "raw input can not be null");

        StringBuilder builder = new StringBuilder();
        for (char c : raw.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                continue;
            }
            builder.append(c);
        }
        return builder.toString();
    }

    static UUID safeParseUuid(String raw) {
        if (raw == null || raw.isBlank()){
            throw new IllegalArgumentException("value cannot be null or empty");
        }

        try {
            return UUID.fromString(raw);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("invalid uuid format given", e);
        }

    }

    static UUID uuidV7() {
        long timestampMillis = System.currentTimeMillis();
        long randomA = SECURE_RANDOM.nextLong() & 0x0FFFL;
        long randomB = SECURE_RANDOM.nextLong() & 0x3FFFFFFFFFFFFFFFL;

        long mostSigBits = (timestampMillis << 16) | 0x7000L | randomA;
        long leastSigBits = 0x8000000000000000L | randomB;

        return new UUID(mostSigBits, leastSigBits);
    }

}
