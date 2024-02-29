public class Ramp {
    private double angle;
    private hasRamp flakstate;

    public Ramp (hasRamp flakstate) {
        this.flakstate = flakstate;
    }

    public void angleSet(double a) { angle = a; }
    public double getAngle() { return angle; }
    public hasRamp getRampState() { return flakstate; }
    public void setRampState(hasRamp b) { flakstate = b;}
    public void lowerRamp(double speed, hasRamp c) {
        if (speed == 0) {
            angle -= 10;
            if (angle < 0) {
                angle = 0;
            }
            setRampState(new LoweredState(c));
        }
    }
    public void raiseRamp(double speed, hasRamp c) {
        if(speed == 0) {
            angle += 10;
            if (angle >= 70) {
                angle = 70;
                setRampState(new RaisedState(c));
            }
        }
    }
}