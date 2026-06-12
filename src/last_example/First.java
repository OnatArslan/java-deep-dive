package last_example;

import java.util.ArrayList;
import java.util.List;

public class First {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Onat", "Arslan"));
        
        names.add("Example");
        System.out.println(names);
        
        
        // Refereance comparison
        String a = "ADMIN";
        String b = "ADMIN";
        
        System.out.println(a == b); // this is false comparison for referance type
        System.out.println(a.equals(b));
        
        String name = "    Adam  ";
        
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can not be blank");
        }
        System.out.println(name.strip().toLowerCase());
        String label = "ADMIN".equals(a) ? "CONNECT" : "NOTCONNECT";
        
        System.out.println(label);
        
        String input = "HIGH";
        
        String warnMessage = switch (input) {
            case "LOW" -> "Not that important";
            case "MEDIUM", "UNKNOWN" -> "You need to check";
            case "HIGH" -> "You must check";
            default -> {
                // we use yield for returning
                System.out.println("Warn important");
                yield "Unkown";
            }
        };
        
        
        System.out.println(warnMessage);
        
    }
    
    static int priorityOf(String status) {
        return switch (status) {
            case "CRITICAL" -> 1;
            // ... diğer case'ler
            default -> 0;
        };   // expression olduğu için ; var
    }
    
    
}
