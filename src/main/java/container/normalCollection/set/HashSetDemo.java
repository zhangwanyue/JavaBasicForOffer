package container.normalCollection.set;


import java.util.*;

public class HashSetDemo {
    public static void main(String[] args){
        Set<String> daysOfWeek = new HashSet<>();
        Collections.addAll(daysOfWeek, "Monday", "Tuesday", "Wednesday");

        List<String> daysList = new LinkedList<>();
        Collections.addAll(daysList, "Monday", "Thursday", "Friday", "Saturday", "Sunday"); // 去重

        daysOfWeek.addAll(daysList);
        System.out.println(daysOfWeek);

    }

}
