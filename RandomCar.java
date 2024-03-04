import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class RandomCar {
    private final Random generator = new Random();
    private ArrayList<Car> cars = new ArrayList<>();
    private int i;
    public RandomCar() {
        this.cars.add(CarFactory.createVolvo(0,0));
        this.cars.add(CarFactory.createSaab(0,200));
        this.cars.add(CarFactory.createScania(0,400));
        this.i = generator.nextInt(cars.size());
    }

    public Car createCar () {
        return cars.get(i);
    }
}



