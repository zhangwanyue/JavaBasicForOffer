package container.normalCollection.map;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

// 该结构使通过红黑树实现的
public class TreeMapDemo {
    public static void main(String[] args){
        TreeMap<String, String> userCityMap = new TreeMap<>();

        // put
        userCityMap.put("John", "New York");
        userCityMap.put("Rajeev", "Bengaluru");
        userCityMap.put("Steve", "London");
        userCityMap.put("Jack", "Beijing");

        // put if absent
        userCityMap.putIfAbsent("John", "Prague");


        // iterate over entrySet using for-each loop（和hashMap不同的地方在于，它的迭代输出的结果根据键值进行了排序）
        System.out.print("iterate over entrySet using for-each loop: ");
        for(Map.Entry<String, String> entry : userCityMap.entrySet()){
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }
        System.out.println();

        // find the user just below Rajeev
        Map.Entry<String, String> userJustBelow = userCityMap.lowerEntry("Rajeev");
        System.out.println("user just below [Rajeev]: " + userJustBelow);


        // custom comparator
        SortedMap<String, String> userCitySortedMap = new TreeMap<>((x1, x2)->(x2.compareTo(x1)));
        userCitySortedMap.putAll(userCityMap);
        System.out.print("custom comparator: ");
        for(Map.Entry<String, String> entry : userCitySortedMap.entrySet()){
            System.out.print(entry.getKey() + ":" + entry.getValue() + " "); // 降序排列
        }
        System.out.println();


        // remove
        Map.Entry<String, String> firstEntry = userCityMap.pollFirstEntry();
        System.out.println("pollFirstEntry: " + firstEntry);

        Map.Entry<String, String> lastEntry = userCityMap.pollLastEntry();
        System.out.println("pollLastEntry: " + lastEntry);
    }
}
