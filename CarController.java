import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CarController implements SubjectObserver{
    // member fields:

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<CarObserver> observers = new ArrayList<>();
    ArrayList<GraphicsObject> graphicCars = new ArrayList<>();
    // The delay (ms) corresponds to 20 updates a sec (hz

    // Calls the gas method for each car once
    void gas(int amounts) {
        double gas = ((double) amounts) / 100;
        for (GraphicsObject o  : graphicCars) {
            o.modelCar.gas(gas);
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
        if(car.getPosition().x >= frame.drawPanel.volvoWorkshopPoint.x && car.getPosition().y > frame.drawPanel.volvoWorkshopPoint.y- 10) {
            verkstad.add(car);
            car.setxPos(frame.drawPanel.volvoWorkshopPoint.x);
            car.setyPos(frame.drawPanel.volvoWorkshopPoint.y);
        }
    }

    void addRandomCar() {
        Random generator = new Random();
        if(cars.size() < 10) {
            int y = generator.nextInt(500); // Hårdkodat in höjd och bredd :/
            Car[] tempCars = new Car[]{CarFactory.createSaab(0, y), CarFactory.createVolvo(0, y), CarFactory.createScania(0, y)};
            int i = generator.nextInt(tempCars.length);
            cars.add(tempCars[i]);
            notifyObserver();
        }
    }

    void removeLatestCar() {
        try {
            cars.removeLast();
            notifyObserver();
        } catch (Exception e){
           throw new IllegalArgumentException ("Carlist is empty");
        }
    }

    @Override
    public void addObserver(CarObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(CarObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (CarObserver o : observers) {
            o.update(cars.getLast());
        }
    }
}

