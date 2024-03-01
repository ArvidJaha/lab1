import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CarController implements SubjectObserver{
    // member fields:

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
        for (GraphicsObject o : graphicCars) {
            o.modelCar.brake(brake);
        }
    }

    void turboOn() {
        for (GraphicsObject o : graphicCars) {
            if (o.modelCar instanceof Saab95) {
                ((Saab95) o.modelCar).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (GraphicsObject  o: graphicCars) {
            if (o.modelCar instanceof Saab95) {
                ((Saab95) o.modelCar).setTurboOff();
            }
        }
    }

    void raiseFlak() {
        for(GraphicsObject o : graphicCars) {
            if (o.modelCar instanceof Scania) {
                ((Scania) o.modelCar).flakstate.raiseRamp();
            }
        }
    }
    void lowerFlak() {
        for(GraphicsObject o : graphicCars) {
            if (o.modelCar instanceof Scania) {
                ((Scania) o.modelCar).flakstate.lowerRamp();
            }
        }
    }

    void stopAllCars() {
        for (GraphicsObject o : graphicCars) {
            o.modelCar.stopEngine();
        }
    }
    void startAllCars() {
        for(GraphicsObject o : graphicCars) {
            o.modelCar.startEngine();
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

    void addRandomCar() throws IOException {
        if(graphicCars.size() < 10) {
            RandomCar randomCar = new RandomCar();
            graphicCars.add(randomCar.createCar());
            notifyObserver();
        }
    }

    void removeLatestCar() {
        try {
            graphicCars.removeLast();
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
            o.update(graphicCars.getLast().modelCar);
        }
    }
}

