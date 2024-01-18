import java.awt.*;

public class car implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    public car(int nrDoors, double enginePower, Color color, String modelName) {
       this.nrDoors = nrDoors;
       this.enginePower = enginePower;
       this.color = color;
       this.modelName = modelName;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }
    public void move() {

    }
    public void turnleft() {

    }
    public void turnright() {

    }
}
