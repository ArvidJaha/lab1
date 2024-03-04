import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;

public class CarController implements SubjectObserver{
    // member fields:

    private ArrayList<CarObserver> observers = new ArrayList<>();
    public ArrayList<Car> cars = new ArrayList<>();

    // The delay (ms) corresponds to 20 updates a sec (hz

    // Calls the gas method for each car once

   public void gas(int amounts) {
        double gas = ((double) amounts) / 100;
        for (Car o  : cars) {
            o.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car o : cars) {
            o.brake(brake);
        }
    }

    public void turboOn() {
        for (Car o : cars) {
            if (o instanceof Saab95) {
                ((Saab95) o).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Car  o: cars) {
            if (o instanceof Saab95) {
                ((Saab95) o).setTurboOff();
            }
        }
    }

    public void raiseFlak() {
        for(Car o : cars) {
            if (o instanceof Scania) {
                ((Scania) o).raiseRamp();
            }
        }
    }
    public void lowerFlak() {
        for(Car o : cars) {
            if (o instanceof Scania) {
                ((Scania) o).lowerRamp();
            }
        }
    }

    public void stopAllCars() {
        for (Car o : cars) {
            o.stopEngine();
        }
    }
    public void startAllCars() {
        for(Car o : cars) {
            o.startEngine();
        }
    }


    public void loadVolvo(Volvo240 car, CarView frame) {
        Verkstad<Volvo240> verkstad = new Verkstad<>(5, frame.drawPanel.volvoWorkshopPoint);
        System.out.println(car.getxPos());
        if(car.getxPos() > frame.drawPanel.volvoWorkshopPoint.x) {
            verkstad.add(car);
            car.setxPos(frame.drawPanel.volvoWorkshopPoint.x);
            car.setyPos(frame.drawPanel.volvoWorkshopPoint.y);
        }
    }

   public void addRandomCar() throws IOException {
        RandomCar randomCar = new RandomCar();
        if (cars.size() < 10) {
            Car addedCar = randomCar.createCar();
            cars.add(addedCar);
            addedCar.startEngine();
            notifyObserver(addedCar, false);
        }
    }


    public void removeLatestCar() {
        try {
            Car removedCar = cars.removeLast();
            notifyObserver(removedCar, true);
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
    public void notifyObserver(Car car, boolean isRemovingCar) {
        for (CarObserver o : observers) {
            o.update(car, isRemovingCar);
        }
    }
}

