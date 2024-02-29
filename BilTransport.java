import jdk.jshell.execution.LoaderDelegate;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayDeque;
import java.util.Deque;

public class BilTransport extends Car implements hasRamp{
    private Ramp ramp;
    private hasRamp flakState;
    private Deque<Car> flaket;
    private final int MAXLOAD;

    public BilTransport(){
        super(2, 90, Color.red, "BilTransport");
        this.flaket = new ArrayDeque<>();
        this.flakState = new LoweredState(this);
        this.ramp = new Ramp(this.flakState);
        this.MAXLOAD = 5;
    }
    public Deque<Car> getFlak() { return flaket; }

    public Ramp getRamp() { return ramp;}
    public void raiseRamp() {ramp.raiseRamp(getCurrentSpeed(), flakState); }

    @Override
    public void setFlakState(hasRamp c) {
        flakState = c;
    }

    public void lowerRamp() {
        ramp.lowerRamp(getCurrentSpeed(), flakState);
    }

    public void loadCar(Car car) {
        Point transportCoordinates = this.getPosition();
        flakState = new LoweredState(this);
        if(flaket.size() <= MAXLOAD && car.getPosition().distance(transportCoordinates) <= 5.0) {
            flaket.push(car);
            car.getPosition().setLocation(transportCoordinates);
        }
        else throw new IllegalArgumentException("error");
    }

    public void unLoadCar() {
        flakState = new LoweredState(this);
        if(!flaket.isEmpty()) {
            flaket.removeLast();
        }
    }

    @Override
    public void gas(double amount) {
        if (bool(amount)) {
            incrementSpeed(amount);
            this.setCurrentSpeed(Math.min(this.getCurrentSpeed(), getEnginePower()));
        }
        this.move();
    }

    // To simplify the code a bit we reduce all conditions to one single method instead.
    private boolean bool (double amount) {
        return this.getCurrentSpeed() >= 0 && this.getCurrentSpeed()<=
                this.getEnginePower() && (amount >= 0 && amount <= 1);
    }

    private double speedFactor() {
        double trimFactor = 0.8;
        return this.getEnginePower() * 0.01 * trimFactor;
    }
    @Override
    protected void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(this.getCurrentSpeed() + speedFactor() * amount, this.getEnginePower()));
    }
    @Override
    protected void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(this.getCurrentSpeed() - speedFactor() * amount, 0));
    }

    @Override
    public void move(){
        if (flakState.getClass().equals(new LoweredState(this))) {
            super.move();
            updateBilTransport();
        }
    }

    public void updateBilTransport () {
        Point transportCoordinates = this.getPosition();
        for (Car c: this.getFlak()) {
            c.getPosition().setLocation(transportCoordinates);
        }
    }
}
