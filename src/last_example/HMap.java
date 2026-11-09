package last_example;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        Map<String, List<Order>> statusMap = new HashMap<>();

        for (Order order : orders) {
            String status = order.getStatus();

            if (!statusMap.containsKey(status)) {
                statusMap.put(status, new ArrayList<>());
            }
            statusMap.get(status).add(order);
        }

        record User(
                String username,
                String email,
                int age
        ) {
        }


        List<User> userList = List.of(new User("kerem", "kerem@gmail.com", 23),new User("onat", "kerem@gmail.com", 23),new User("adam", "kerem@gmail.com", 23));

        List<User> onat = userList.stream().filter(user -> user.username.equals("onat")).toList();

        Map<String, User> userMap = userList.stream().collect(Collectors.toMap(User::username, user -> user));
        userMap.get("onat");
        System.out.println(onat);
        return statusMap;
    }

    public static Map<Integer, Integer> twoSum(List<Integer> list, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i <= 0; i++) {
            int remain = target - list.get(i);
            if (seen.containsKey(remain)) {
                return Map.of(list.get(i), list.get(remain));
            }
            seen.put(i, list.get(i));
        }
        return Map.of(0, 0);
    }

}

