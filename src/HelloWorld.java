import java.util.ArrayList;

import java.util.List;



public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");

        List<String> list = new ArrayList<>(List.of("Banana", "Apple"));

        String status = "Closed";

        System.out.println(status.equals("OPEN"));


        System.out.println(status.startsWith("Clo"));

        System.out.println("Hello world");


        String prefix = "Clo";

        System.out.println(status.substring(prefix.length()));

        String priority = "HIGH";

        switch (priority) {
            case "CRITICAL" -> System.out.println("Immediate response required");
            case "HIGH" -> System.out.println("Response required within 4 hours");
            case "NORMAL" -> System.out.println("Response required within 24 hours");
            case "LOW" -> System.out.println("Response required within 72 hours");
            default -> System.out.println("Unknown priority");
        }


        String infoStatus = "critical";

        switch (infoStatus){
            case "critical" -> System.out.println("CRITICAL");
            case "basic" -> System.out.println("NOT CRITICAL");
        }


        for (int i = 0; i < 2; i++) {
            System.out.println("Hello world: " + i);
        }


        String[] names = {"Onat", "Melisa", "Adam"};

        for (String name : names) {
            System.out.println();
        }
        List<Integer> list2 = List.of(1,2,3,4,5,6,7);


    }
    }






