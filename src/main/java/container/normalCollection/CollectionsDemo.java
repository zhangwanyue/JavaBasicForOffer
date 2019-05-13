package container.normalCollection;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args){

        // returns an empty list (immutable), a list to which you cannot add elements.
        List<String> immutableList = Collections.EMPTY_LIST;
        List<String> fruits = new ArrayList<>();

        // addAll
        Collections.addAll(fruits, "Apple", "Oranges", "Banana");
        System.out.println("-----------addAll-----------");
        fruits.forEach(System.out::println);

        // sort
        Collections.sort(fruits);
        System.out.println("-----------sort in ascending order-----------");
        fruits.forEach(System.out::println);

        Collections.sort(fruits, Comparator.reverseOrder());
        System.out.println("-----------sort in descending order-----------");
        fruits.forEach(System.out::println);

        // asLifoQueue(this method returns a view of Deque as a last-in-first-out Queue)
        Deque deque = new LinkedList();
        deque.addFirst("Apple");
        deque.add("Oranges");
        deque.addLast("Bananas");
        System.out.println("-----------new a deque-----------");
        deque.forEach(System.out::println);

        Queue queue = Collections.asLifoQueue(deque); // the Collections.asLifoQueue method doesn't affect elements already in the original collection(ref:https://stackoverflow.com/questions/42750309/why-java-collections-aslifoqueue-is-not-lifo)
        System.out.println("-----------asLifoQueue-----------");
        queue.add("Pear");
        queue.add("Peach");
        queue.add("Watermelon");
        queue.forEach(System.out::println);


    }
}
