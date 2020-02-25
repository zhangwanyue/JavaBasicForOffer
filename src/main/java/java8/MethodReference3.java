package java8;

import java.util.ArrayList;

public class MethodReference3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.forEach(x->System.out.println(x));
        arrayList.forEach(System.out::println);
    }
}
