package generic;


class DataHolder<T>{
    T item;

    public void setData(T t){
        this.item = t;
    }

    public T getData(){
        return this.item;
    }

    public <E> void PrinterInfo(E e){
        System.out.println(e);
    }
}

public class GenericClassAndMethod {

    public static void main(String[] args){
        DataHolder<String> dataHolder = new DataHolder<>(); // 泛型类
        dataHolder.PrinterInfo(1); // 泛型方法（可以和泛型类的类型不同）
        dataHolder.PrinterInfo(88.8f);
    }
}
