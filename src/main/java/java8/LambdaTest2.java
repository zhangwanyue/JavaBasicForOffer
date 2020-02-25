package java8;

import java.util.Arrays;
import java.util.List;

public class LambdaTest2 {
    public static void main(String[] args){
        //Old way:
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for(Integer n: list1) {
            System.out.println(n);
        }

        //New way:
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list2.forEach(n -> System.out.println(n));


        //Old way:
        List<Integer> list3 = Arrays.asList(1,2,3,4,5,6,7);
        for(Integer n : list3) {
            int x = n * n;
            System.out.println(x);
        }

        //New way:
        List<Integer> list4 = Arrays.asList(1,2,3,4,5,6,7);
        list4.stream().map((x) -> x*x).forEach(System.out::println);
    }
}
