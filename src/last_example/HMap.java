package last_example;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class HMap {
    public static void main(String[] args) {
        Map<String,User> name = new HashMap<>();

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 90, 13, 16, 900));

        List<Integer> sortedList = list.stream().sorted(Comparator.comparing(Integer::valueOf)).toList();
        List<Integer> reverseList = list.stream().sorted(Comparator.comparing(Integer::valueOf, Comparator.reverseOrder())).toList();

        System.out.println(sortedList);
        System.out.println(reverseList);
    }


    public static Map<String, List<Order>> groupByStatus(List<Order> orders) {
        Map<String,List<Order>> statusMap = new HashMap<>();

        for (Order order : orders) {
            String status = order.getStatus();

            if (!statusMap.containsKey(status)) {
                statusMap.put(status, new ArrayList<>());
            }
            statusMap.get(status).add(order);
        }


            return statusMap;
    }

}

