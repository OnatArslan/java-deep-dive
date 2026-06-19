package last_example;

public class Printer<T> {
    private T value;

    public Printer(T value) {
        this.value = value;
    }

    public void print(){
        System.out.println(this.value);
    }

    public static <T extends Integer> int getDouble(T value) {
        return value * 2;
    }


    public static void main(String[] args) {
        Printer<String> stringPrinter = new Printer<>("Onat Arslan");
        stringPrinter.print();

        Printer<Integer> intPrinter = new Printer<>(19);
        intPrinter.print();

    }

}











