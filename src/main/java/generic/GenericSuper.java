package generic;

// 上界通配符<? super T>不影响往里存，但是往外取只能放在Object对象里
public class GenericSuper {
    public static void main(String[] args){
        Plate<? super Apple> plate = new Plate<>();
        plate.set(new GreenApple("green")); // 下界通配符规定了元素的最小粒度，必须是Apple及其父类。所以Apple及它的子类都可以放进去
        System.out.println(plate.get().getClass()); // 泛型擦除不影响放入的数据的多态性
        Object object = plate.get(); // 但是取出的时候，类型直接被擦除到了Object
        GreenApple greenApple = (GreenApple)plate.get(); // 可以使用强制类型转换

    }

}
