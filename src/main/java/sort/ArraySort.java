package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by vera on 19-3-18.
 */
public class ArraySort {
    public static void main(String[] args){
        Integer[] array = {1,2,3}; //不能使用基本类型，而要使用它们对应的类
        Arrays.sort(array,new MyComparator());
//        Arrays.sort(array, Comparator.reverseOrder());
        for(int a : array){
            System.out.println(a);
        }
    }
}

//反向排序
class MyComparator implements Comparator<Integer>{
    //当返回值>0时，进行交换
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 < o2){
            return 1;
        }else if(o1 > o2){
            return -1;
        }else{
            return 0;
        }
    }
}
