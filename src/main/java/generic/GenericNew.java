package generic;

// 解决泛型擦除导致无法new T()的问题

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