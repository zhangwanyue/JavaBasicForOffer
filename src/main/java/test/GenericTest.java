package test;

class Fruit{}
class Apple extends Fruit{
    String name;

    public Apple(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Plate<T>{
    T item;

    public Plate(T item) {
        this.item = item;
    }

    public void set(T t){
        item = t;
    }

    public T get(){
        return item;
    }
}

public class GenericTest {
    public static void main(String[] args){
        Plate<? extends Fruit> plate = new Plate<>(new Apple("red"));
//        System.out.println(plate.get().getClass());
        Fruit apple1 = plate.get(); // 但是放进去的元素还是保持着多态性，类型擦除的是泛型的类型，并不擦除实际放进去的元素的类型啊！！！
//        Apple apple2 = (Apple)plate.get(); // 类型被擦除了，需要强制类型转换
//        Fruit fruit1 = new Apple("apple1");

    }
}
