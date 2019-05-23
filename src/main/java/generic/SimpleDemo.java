package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleDemo {
    public static void main(String[] args){
        List list1 = new ArrayList<Integer>();
        list1.add(0, "hello");
        list1.add(1, 100);
        list1.forEach(System.out::println);
//        System.out.println((String)list1.get(1));//编译期不会检查出问题，但是运行期会报ClassCastException
        //一个Integer的ArrayList，居然可以存放"hello"这个String。这是因为泛型擦除机制。
        //可以看到Integer被擦除到了E
        System.out.println(Arrays.toString(list1.getClass().getTypeParameters()));

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(0, 100);
//        list2.add(1, "hello"); //定义为List<Integer>，在编译期可以检查出错误
        //但是仍然可以看到发生了泛型擦除，擦除到了E
        System.out.println(Arrays.toString(list2.getClass().getTypeParameters()));



    }
}
