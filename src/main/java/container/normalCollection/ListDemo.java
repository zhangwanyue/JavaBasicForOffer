package container.normalCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// normal collection and synchronized collection
public class ListDemo {

    public static void main(String[] args){
        // 1. List
        // 1.1 ArrayList
        List<String> strList = new ArrayList<>();
        strList.add(0, "0");
        strList.add(1, "1");
        strList.forEach(System.out::println);
        System.out.println(Arrays.toString(strList.getClass().getTypeParameters()));




        // 1.2 LinkedList

        // 1.3 Vector(sync)


        // 2. Set
        // 2.1 HashSet

        // 2.2 TreeSet


        // 3. Queue
        // 3.1 PriorityQueue



        // 4. Map(Map is the only interface that doesn't inherit from Collection interface but it's part of Collections framework.
        // 4.1 HashMap

        // 4.2 TreeMap

        // 4.3 LinkedHashMap



        // 5. Collections

    }


}
