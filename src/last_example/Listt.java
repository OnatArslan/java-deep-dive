package last_example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Listt {
    public static void main(String[] args) {
        String[] stringArr = new String[]{"Onat", "Arslan", "Is", "Good"};

        List<String> stringList = List.of(stringArr); // this is immutable list
        System.out.println(stringList);

        // List.of() always return unmutable list but new Arraylist<>() return mutable

        List<String> mutableList = new ArrayList<>(List.of(stringArr)); // we can mutate this

        List<Integer> intList = new ArrayList<>(List.of(1,2,3,4,5,6,7,8));

        // For Integer List we need to use valuof for deleting object because 7 is also int (index)

        intList.remove(Integer.valueOf(7)); // delete 7 from list
        intList.remove(2); // delete value at index 2

        System.out.println(intList);
        for(int i =0; i < stringArr.length;i++){
            System.out.println(i);
        }

        Iterator<Integer> it = intList.iterator();

        while(it.hasNext()){
            Integer num = it.next();
            System.out.println(num);
        }

        List<Session> sessions = new ArrayList<>();
        Iterator<Session> sesIt = sessions.iterator();

        while(sesIt.hasNext()){
            Session session = sesIt.next();
            if (!session.isActive()){
                sesIt.remove(); // we use it.remove() because of CMP
            }
        }
        sessions.removeIf(session -> {
            if (!session.isActive()) {
                System.out.printf("session removed: %s%n", session.getTitle());
                return true;   // inactive → sil
            }

            return false;      // active → tut

        });

        List<Integer> numList = new ArrayList<>(List.of(100, 99, 98, 97, 96));

        List<Integer> evenList = numList.stream().filter(Listt::isEven).toList();
        System.out.println(evenList);

    }

    static boolean isEven(Integer el) {
        return el % 2 == 0;
    }

}
