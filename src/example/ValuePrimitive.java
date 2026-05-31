package example;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.*;


public class ValuePrimitive {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static void main(String[] args) {


        System.out.println(stripString("    onat is goddamn good   "));

        BigDecimal a = new BigDecimal("12.99");
        BigDecimal b = new BigDecimal("119.94");

        System.out.println(b.compareTo(a));

        String rawUuid = "550e8400-e29b-41d4-a716-446655440000";
        String invalidUuid = "not-a-uuid";


        List<Integer> intList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        intList.add(12);
        intList.add(14);


        List<Integer> newList = intList.stream().sorted(Integer::compareTo).toList();


        System.out.println(newList);


        UUID uuidV7 = uuidV7();

        System.out.println(uuidV7);
        System.out.println(uuidV7.version());

        List<String> listOfStr = new ArrayList<>(List.of("Onat", "Adam", "Cannot"));


        Iterator<String> iterator = listOfStr.iterator();


        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        System.out.println(getFullname("Onat", "Arslan"));

        for (String arg : args) {
            System.out.println(arg);
        }
    }

    static String getFullname(String name, String surname) {
        StringBuilder builder = new StringBuilder();

        builder.append(name);
        builder.append(" ");
        builder.append(surname);

        return builder.toString();
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
        if (raw == null || raw.isBlank()) {
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
