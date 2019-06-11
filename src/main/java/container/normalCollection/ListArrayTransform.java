package container.normalCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListArrayTransform {
    public static void main(String[] args){
        // 数组转集合
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "A", "B", "C");
        String[] strArray = {"D", "E"};
        Collections.addAll(list, strArray);

//        List list1 = Arrays.asList(strArray); // 不要使用这种方式让数组转集合，asList的返回对象使一个Arrays内部类，并没有实现集合的修改方法。转出的集合，不能使用其修改集合相关的方法。

//        String[] array = (String[])list.toArray(); //Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
        // 使用泛型,无需显式类型转换
        String[] array = list.toArray(new String[list.size()]); // 阿里开发手册强制要求：使用集合转数组的方法，必须使用集合的toArray(T[] array)，传入的使类型完全一样的数组，大小就是list.size();
        System.out.println(Arrays.toString(array));
    }
}
