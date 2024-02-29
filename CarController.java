import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CarController {
    // member fields:

    ArrayList<Car> cars = new ArrayList<>();
    // The delay (ms) corresponds to 20 updates a sec (hz

    // Calls the gas method for each car once
    void gas(int amounts) {
        double gas = ((double) amounts) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Car c : cars) {
            if (c instanceof Saab95) {
                ((Saab95) c).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car c : cars) {
            if (c instanceof Saab95) {
                ((Saab95) c).setTurboOff();
            }
        }
    }

    void raiseFlak() {
        for(Car c : cars) {
            if (c instanceof Scania) {
                ((Scania) c).flakstate.raiseRamp();
            }
        }
    }
    void lowerFlak() {
        for(Car c : cars) {
            if (c instanceof Scania) {
                ((Scania) c).flakstate.lowerRamp();
            }
        }
    }

    void stopAllCars() {
        for (Car c : cars) {
            c.stopEngine();
        }
    }
    void startAllCars() {
        for(Car c : cars) {
            c.startEngine();
        }
    }

    void loadVolvo(Volvo240 car, CarView frame) {
        Verkstad<Volvo240> verkstad = new Verkstad<>(5, frame.drawPanel.volvoWorkshopPoint);
        if(car.getPosition().x < frame.drawPanel.volvoWorkshopPoint.x) {
            verkstad.add(car);
            car.setxPos(frame.drawPanel.volvoWorkshopPoint.x);
            car.setyPos(frame.drawPanel.volvoWorkshopPoint.y);
        }
    }

    void addRandomCar() {
        Random generator = new Random();
        int y = generator.nextInt(400); // Hårdkodat in höjd och bredd :/
        int x = generator.nextInt(800);
        Car[] tempCars = new Car[] {CarFactory.createSaab(x,y), CarFactory.createVolvo(x,y), CarFactory.createScania(x,y)};
        int i = generator.nextInt(tempCars.length);
        cars.add(tempCars[i]);
    }

    void removeLatestCar() {
        try {
            cars.removeLast();
        } catch (Exception e){
           throw new IllegalArgumentException ("Carlist is empty");
        }
    }
}

