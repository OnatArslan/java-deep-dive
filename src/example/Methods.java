package example;

public class Methods {
    public static void main(String[] args) {
        System.out.println("method chapter starts here");
        
        
        System.out.println(getFullString(new String[]{"Onat", "Arslan"}));
        
        System.out.println(Methods.labelPriority(2));
        
        String name = "OnatArslanissogood";
        
        System.out.println(name.substring(name.indexOf("so")));

//      3.47 shadowing
    
    
    }
    
    static String getFullString(String... strings) {
        StringBuilder builder = new StringBuilder();
        
        for (String string : strings) {
            builder.append(string);
            builder.append(" ");
        }
        
        return builder.toString().trim();
        
    }
    
    static String labelPriority(int priority) {
        return switch (priority) {
            case 1 -> "HIGH";
            case 2 -> "MEDIUM";
            case 3 -> "LOW";
            default -> "UNKNOWN";
        };
    }
}

