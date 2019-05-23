package generic;

import java.lang.reflect.Array;
import java.util.Arrays;

// 解决创建泛型数组的问题
public class GenericNewArray<T> {
    private T[] array;

    public GenericNewArray(Class<T> type, int sz) {
        this.array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item){
        array[index] = item;
    }

    public T get(int index){
        return array[index];
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args){
        GenericNewArray<String> genericNewArray = new GenericNewArray<>(String.class, 10);
        genericNewArray.put(0, "hello");
        System.out.println(genericNewArray.get(0));
        System.out.println(Arrays.toString(genericNewArray.rep()));
    }
}
