public class LoweredState implements hasRamp {
    private hasRamp c;

    public LoweredState(hasRamp c) {
        this.c = c;
    }

    public void lowerRamp() {
        System.out.println("Already lowered");
    }

    @Override
    public void raiseRamp() {
        c.raiseRamp();
    }

    @Override
    public void setFlakState(hasRamp c) {
        this.c = c;
    }
}
