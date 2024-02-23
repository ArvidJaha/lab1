import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
                ((Scania) c).raiseRamp();
            }
        }
    }
    void lowerFlak() {
        for(Car c : cars) {
            if (c instanceof Scania) {
                ((Scania) c).lowerRamp();
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
        if(car.getxPos() >= frame.drawPanel.volvoWorkshopPoint.x) {
            verkstad.add(car);
            car.setxPos(frame.drawPanel.volvoWorkshopPoint.x);
            car.setyPos(frame.drawPanel.volvoWorkshopPoint.y);
        }
    }
}

