package example;

import java.util.*;

public class VarControl {
    public static void main(String[] args) {
        
        
        Status exampleStatus = Status.CLOSED;
        
        System.out.println(exampleStatus instanceof Status);
        
        String email = "  oNatArs@GmAil.COM     ";
        
        String normalizedEmail = email != null && email.contains("@") ? email.strip().toLowerCase(Locale.ROOT) : "";
        
        if (normalizedEmail.isBlank()) {
            System.out.println("invalid email given");
            return;
        }
        
        System.out.println(normalizedEmail);
        
        String title = "Example title";
        int prio = 1;
        
        boolean isTitleValid = title != null && !title.trim().isBlank();
        
        boolean isEqual = Objects.equals("ADMIN", title);
        System.out.println(isEqual);
        
        if (isTitleValid && prio == 1) {
            System.out.println(title + " " + "prio: " + prio);
        } else {
            System.out.println("invalid title");
        }
        
        int priority = 3;
        
        switch (priority) {
            case 1 -> System.out.println("case is 1");
            
            case 2 -> System.out.println("case is 2");
            
            case 3 -> System.out.println("case is 3");
            
            default -> System.out.println("invalid case");
        }
        
        String label = switch (priority) {
            case 1 -> "HIGH";
            
            case 2 -> "NORMAL";
            
            case 3, 4, 5 -> "LOW";
            
            default -> "INVALID";
        };
        System.out.println(label);
        
        String queue = switch (priority) {
            case 1 -> {
                System.out.println("priority is one");
                yield "ADDED";
            }
            case 2 -> {
                System.out.println("priority is none");
                yield "NOT ADDED";
            }
            default -> {
                System.out.println("priority is not valid");
                yield null;
            }
        };
        
        
        System.out.println(queue);
        
        int number = 12;
        
        for (int i = number; i >= 0; i--) {
            System.out.println(i);
        }
        
        List<Integer> list = customRange(12, 20);
        
        for (Integer val : list) {
            System.out.println(val);
            
            
        }
        
        String[] roles = {"USER", "MODERATOR", "ADMIN", "BANNED"};
        
        boolean hasAccess = Arrays.stream(roles).anyMatch((val) -> "ADMIN".equals(val));
        
        List<String> explainList = List.of(roles).stream().map((value) -> {
            return "role is: " + value;
        }).toList();
        
        
        List<Integer> newList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        
        
        System.out.println(explainList);
        
        System.out.println(hasAccess);
//        for (String role : roles) {
//            if ("ADMIN".equals(role)) {
//                hasAccess = true;
//                break;
//            }
//        }
//
//        System.out.println(hasAccess);
        
    }
    
    
    public static List<Integer> customRange(int start, int end) {
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = start; i < end; i++) {
            list.add(i);
        }
        return list;
    }
    
    // so fucking good twoSum solution
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookup = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            
            if (lookup.containsKey(rem)) {
                return new int[]{lookup.get(rem), i};
            }
            
            lookup.put(nums[i], i);
        }
        throw new IllegalArgumentException("not found");
    }
    
}






