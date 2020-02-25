package java8;

public class MethodReference2 {
    public static void main(String[] args) {
        Train train = new Train();
        MyTest<Train> myTest = new MyTest<>(train);
        myTest.test(Train::showTrain);

        Action<Train> trainAction = Train::showTrain; //类名::实例方法名

        Action<Train> trainAction2 = (x)->System.out.println("train");

        Action<Train> trainAction3 = System.out::println;

        Action2 action2 = (new Train())::showTrain;
        Action2 action3 = ()->System.out.println("train");
        Action2 action4 = (new MethodReference2())::show;
        Action2 action5 = System.out::println; // 实例::实例方法名
    }

    public void show(){
        System.out.println("show");
    }
}

class Train{
    public void showTrain(){
        System.out.println(this.toString());
    }
}

@FunctionalInterface
interface Action<T>{
    void doAction(T t);
}

class MyTest<E>{
    private E e;

    public MyTest(E e){
        this.e = e;
    }
    public void test(Action<E> action){
        action.doAction(e);
    }
}

@FunctionalInterface
interface Action2{
    void doAction();
}