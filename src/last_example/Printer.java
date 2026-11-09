package last_example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

        List<Integer> intList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        List<Integer> evenNums = intList.stream().filter((num) -> num % 2 == 0).sorted(Comparator.comparing( a-> a, Comparator.reverseOrder())).toList();
        System.out.println(evenNums);

    }

}











