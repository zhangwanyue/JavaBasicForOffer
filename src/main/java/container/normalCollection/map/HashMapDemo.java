package container.normalCollection.map;


import java.util.*;

// 4. Map(Map is the only interface that doesn't inherit from Collection interface but it's part of Collections framework.
// 该结构是通过：数组+链表/红黑树 实现的
public class HashMapDemo {
    public static void main(String[] args){
        Map<String, String> userCityMap = new HashMap<>();

        // is empty
        System.out.println("is empty: " + userCityMap.isEmpty());

        // put
        userCityMap.put("John", "New York");
        userCityMap.put("Rajeev", "Bengaluru");
        userCityMap.put("Steve", "London");
        userCityMap.put("Jack", "Beijing");

        // put if absent
        userCityMap.putIfAbsent("John", "Prague");

        // print map
        System.out.println("origin map: " + userCityMap);
        userCityMap.forEach((x1, x2)->System.out.print(x1 + ":" + x2 + " "));
        System.out.println();

        // check if a key exists in the HashMap & get
        if(userCityMap.containsKey("John")){
            System.out.println("check if a key exists [John]: "+userCityMap.get("John"));
        }
        // check if a value exists in the HashMap
        if(userCityMap.containsValue("New York")){
            System.out.println("value [New York] exists");
        }else{
            System.out.println("value [New York] doesn't exists");
        }

        // entry set
        Set<Map.Entry<String, String> > userCityMapEntrySet = userCityMap.entrySet();
        System.out.println("userCityMap entries: " + userCityMapEntrySet);

        // key set
        Set<String> user = userCityMap.keySet();
        System.out.println("keySet: " + user);

        // values
        Collection<String> city = userCityMap.values();
        System.out.println("values: " + city);

        // iterate over entrySet using iterator
        Iterator<Map.Entry<String, String>> userCityMapEntryIter = userCityMapEntrySet.iterator();
        System.out.print("iterate over entry set using iterator: ");
        while(userCityMapEntryIter.hasNext()){
            Map.Entry<String, String> userCityMapEntry = userCityMapEntryIter.next();
            System.out.print(userCityMapEntry.getKey() + ":" + userCityMapEntry.getValue() + " ");
        }
        System.out.println();

        // iterate over entrySet using for-each loop
        System.out.print("iterate over entrySet using for-each loop: ");
        for(Map.Entry<String, String> entry : userCityMapEntrySet){
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }
        System.out.println();

        // iterate over keySet
        System.out.print("iterate over keySet: ");
        for(String user1 : userCityMap.keySet()){
            System.out.print(user1 + ":" + userCityMap.get(user1) + " ");
        }
        System.out.println();

        // remove
        userCityMap.remove("Jack");
        System.out.println("remove Jack: " + userCityMap);

        boolean isRemoved = userCityMap.remove("Jack", "Beijing");
        System.out.println("is Jack removed successful: " + isRemoved); // [Jack:Beijing]之前已经被删除了，所以这次删除失败
    }


}
