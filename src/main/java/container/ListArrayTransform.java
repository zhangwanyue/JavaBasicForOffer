package container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListArrayTransform {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, "A", "B", "C");
//        String[] array = (String[])list.toArray(); //Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;

        // 使用泛型,无需显式类型转换
        String[] array = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(array));
    }
}
