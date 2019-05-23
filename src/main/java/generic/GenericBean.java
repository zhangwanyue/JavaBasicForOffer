package generic;

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

class Banana extends Fruit{
    String name;

    public Banana(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Banana{" +
                "name='" + name + '\'' +
                '}';
    }
}

class GreenApple extends Apple{
    String name;

    public GreenApple(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "GreenApple{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Plate<T>{
    T item;

    public Plate() {
    }

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