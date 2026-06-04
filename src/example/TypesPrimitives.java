package example;

public class TypesPrimitives {
    public static void main(String[] args) {
        // primitives hold real values not references
        // wrappers are objects and they can be null
        
        String name = null;
        
        System.out.println(name.length()); // null pointer exception
        
    }
}
