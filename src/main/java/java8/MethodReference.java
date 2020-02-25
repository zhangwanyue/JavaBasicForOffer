package java8;

import java.util.ArrayList;

public class MethodReference {
    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Car car = Car.create(Car::new);
            cars.add(car);
        }
        cars.forEach(Car::showCar);

        // Lambda
        Factory<Car> factory1 = ()->new Car();
        Car car1 = Car.create(factory1);
        //Car car1 = factory1.create();
        car1.showCar();

        // MethodReference
        Factory<Car> factory2 = Car::new;
        Car car2 = Car.create(factory2);

    }
}

class Car {
    public void showCar() {
        System.out.println(this.toString());
    }

    public static Car create(Factory<Car> factory) {
        return factory.create();
    }
}

@FunctionalInterface
interface Factory<T> {
    T create();
}
