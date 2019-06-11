package container.normalCollection.map;

import java.util.LinkedHashMap;
import java.util.Map;

// 和HashMap不同，LinkedHashMap的迭代输出的结果保持了插入顺序。使用HashMap+双向链表，双向链表保证了迭代顺序使插入的顺序，HashMap保证查找的时间复杂度是O(1)
public class LinkedHashMapDemo {
    public static void main(String[] args){
        Map<String, String> userCityMap = new LinkedHashMap<>();

        // put
        userCityMap.put("John", "New York");
        userCityMap.put("Rajeev", "Bengaluru");
        userCityMap.put("Steve", "London");
        userCityMap.put("Jack", "Beijing");

        // put if absent
        userCityMap.putIfAbsent("John", "Prague");


        // iterate over entrySet using for-each loop（和hashMap不同的地方在于，它的迭代输出的结果保持了插入的顺序）
        System.out.print("iterate over entrySet using for-each loop: ");
        for(Map.Entry<String, String> entry : userCityMap.entrySet()){
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }
        System.out.println();
    }
}
