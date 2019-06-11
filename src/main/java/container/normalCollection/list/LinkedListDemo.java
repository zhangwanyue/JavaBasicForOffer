package container.normalCollection.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.function.Predicate;

public class LinkedListDemo {
    public static void printStrList(String msg, LinkedList<String> list){
        System.out.print(msg + ": ");
        list.forEach(x->System.out.print(x + " "));
        System.out.println();
    }


    public static void main(String[] args){
        LinkedList<String> friends = new LinkedList<>();
        Collections.addAll(friends, "John", "David", "Chris", "Alice", "Bob");
        printStrList("original LinkedList", friends);

        // add elements
        friends.addFirst("Paul"); // 和friends.add("Paul")作用相同
        printStrList("add Paul to the first element", friends);
        friends.add(3, "Lisa");
        printStrList("add Lisa to the third element", friends);
        friends.addLast("Steve");
        printStrList("add steve to the last element", friends);

        // search elements
        System.out.println("get first elements: " + friends.getFirst());
        System.out.println("get last elements: " + friends.getLast());
        System.out.println("get index 2: " + friends.get(2));
        System.out.println("get indexOf Lisa: " + friends.indexOf("Lisa"));

        // remove elements
        friends.removeFirst(); // 和friends.remove()作用相同
        printStrList("remove first", friends);
        friends.remove(2);
        printStrList("remove index 2", friends);
        friends.remove("Steve");
        printStrList("remove Steve", friends);
        friends.removeLast();
        printStrList("remove last", friends);
        friends.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("A");
            }
        });
        printStrList("remove elements start with A", friends);

    }
}
