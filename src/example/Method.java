package example;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Method {

    public static void main(String[] args) {
        System.out.println("say hi");

        System.out.println(Boolean.TRUE.equals(true));

        String email = null;

        System.out.println();


        Long currentUserId = 42L;

        BigDecimal a = new BigDecimal("10.00");
        BigDecimal b = new BigDecimal("10.0");

        System.out.println(a.compareTo(b)==0);

        UUID id = UUID.randomUUID();

        String name = "Onat Arslan";

        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));
        }

        char m = 'a';

        Character n = 'a';




    }
}
