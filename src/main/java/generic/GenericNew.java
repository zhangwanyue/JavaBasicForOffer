package generic;

// 解决泛型擦除导致无法new T()的问题
// 泛型代码中不能new T()的原因有两个，一是因为擦除，不能确定类型；二是无法确定T是否包含无参构造函数

interface Factory<T>{
    T create();
}

public class GenericNew<T> {
    T instance;

    public <F extends Factory<T>> T newInstance(F f){
        instance = f.create();
        return instance;
    }
}

class IntegerFactory implements Factory<Integer>{
    @Override
    public Integer create() {
        Integer integer = new Integer(9);
        return integer;
    }
}

class StringFactory implements Factory<String>{
    @Override
    public String create() {
        String str = new String("hello");
        return str;
    }
}

class Test{
    public static void main(String[] args){
        GenericNew<Integer> genericInteger = new GenericNew<>();
        IntegerFactory integerFactory = new IntegerFactory();
        System.out.println(genericInteger.newInstance(integerFactory));

        GenericNew<String> genericStr = new GenericNew<>();
        StringFactory stringFactory = new StringFactory();
        System.out.println(genericStr.newInstance(stringFactory));
    }
}