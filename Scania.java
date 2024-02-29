import java.awt.*;

public class Scania extends Car implements hasRamp {
    protected hasRamp flakstate;
    private final Ramp ramp;

    public Scania() {
        super(2, 90, Color.cyan, "Scania");
        this.flakstate = new LoweredState(this); // sätter så att flaket är nere från början.
        this.ramp = new Ramp(this.flakstate);
    }
    public void setFlakState (hasRamp flakState) {
        this.flakstate = flakState;
    }
    public void raiseRamp() {
        ramp.raiseRamp(this.getCurrentSpeed(), flakstate);
    }

    public void lowerRamp() {
        ramp.lowerRamp(this.getCurrentSpeed(), flakstate);
    }

    public Ramp getRamp() {
        return ramp;
    }

    @Override
    public void gas(double amount) {
        if (this.ramp.getAngle() == 0 && bool(amount)) {
            incrementSpeed(amount);
            this.setCurrentSpeed(Math.min(this.getCurrentSpeed(), getEnginePower()));
        }
    }

    private boolean bool(double amount) {
        return this.getCurrentSpeed() >= 0 && this.getCurrentSpeed() <=
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
        if(this.ramp.getAngle() == 0) {
            super.move();
        }
    }
}

