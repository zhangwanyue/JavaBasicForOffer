package java8;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args){
        test6();
    }

    public static void test1(){
        //of() 为非 null 的值创建一个 Optional 实例
        //isPresent() 如果值存在，返回 true，否则返回 false
        //get() 返回该对象，有可能返回 null
        Optional<String> op1 = Optional.of("Hello");
        System.out.println(op1.isPresent()); // 输出 true
        System.out.println(op1.get()); // 输出 Hello
        Optional<String> op2 = Optional.of(null); // 抛出异常
    }

    public static void test2(){
        //OfNullable() 如果指定的值为 null，返回一个空的 Optional
        Optional<String> op2 = Optional.ofNullable(null);
        System.out.println(op2.isPresent()); // 输出 false
    }

    public static void test3(){
        //ifPresent() 如果实例非空，调用 Comsumer Lambda 表达式
        Optional<String> op1 = Optional.of("Hello");
        op1.ifPresent((s) -> {
            System.out.println(s); // 输出 Hello
        });
    }

    public static void test4(){
        //map() 如果实例非空，调用 Function Lambda 表达式
//        Optional<String> op1 = Optional.of("Hello");
        Optional<String> op1 = Optional.ofNullable(null);
        Optional<String> op2 = op1.map((s) -> s.toUpperCase());
        op2.ifPresent((s) -> {
            System.out.println(s); // 输出 HELLO
        });
    }

    public static void test5(){
        //orElse(obj) 如果实例非空，返回该实例，否则返回 obj
        Optional<String> op1 = Optional.of("Hello");
        System.out.println(op1.orElse("World")); // 输出 Hello
        Optional<String> op2 = Optional.ofNullable(null);
        System.out.println(op2.orElse("World")); // 输出 World
    }

    public static void test6(){
        //orElseGet(Supplier<? extends T> other) 如果实例非空，返回该实例，否则返回 Supplier
        Optional<String> op1 = Optional.of("Hello");
        System.out.println(op1.orElseGet(() -> {return new String("World");})); // 输出 Hello
        Optional<String> op2 = Optional.ofNullable(null);
        System.out.println(op2.orElseGet(() -> {return new String("World");})); // 输出 World
    }
}
