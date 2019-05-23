package generic;

import java.util.Arrays;


// 上界通配符<? extends T>不能往里存，只能往外取
public class GenericExtend {
    public static void main(String[] args){
        // 数组的协变
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple("apple1");
        fruits[1] = new GreenApple("apple2");
//        fruits[2] = new Banana("banana1"); // java.lang.ArrayStoreException: generic.Banana
        System.out.println(Arrays.toString(fruits));

//        Plate<Fruit> plate1 = new Plate<Apple>(); // 泛型不支持协变
        // 使用上界通配符解决”装苹果的盘子“无法转换成”装水果的盘子“的问题
        // <? extends Fruit> 是 Fruit 和 Apple 的父类，通配符表示的是一个类型，这个类型是Fruit和它的派生类中的某一种
        Plate<? extends Fruit> plate = new Plate<>(new Apple("apple4"));
//        plate.set(new Apple("red")); // <? extends Fruit>会使往盘子里放东西的set()方法失效，Java编译期只知道容器里面存放的是Fruit和它的派生类中的某一种，但是不知道具体使什么类型.
        // 编译器在后面看到Plate<Apple>赋值以后，盘子里面没有标记为“Apple”。只是标记了一个占位符“CAP#1”，来表示捕获一个Fruit或者Fruit的派生类，具体是什么类型不知道。
        // 所有调用代码无论往容器里面插入Apple或者Banana编译器都不知道能不能和这个“CAP#1”匹配，所以这些操作都不允许。
        System.out.println(plate.get().getClass()); // 但是允许读操作，放进去的元素还是保持着多态性，类型擦除的是泛型的类型，并不擦除实际放进去的元素的类型啊！！！
        Fruit apple1 = plate.get(); // 读取出来的东西只能放到Fruit或者它的基类里
//        Apple apple2 = (Apple)plate.get(); // 类型被擦除了，需要强制类型转换

    }
}
