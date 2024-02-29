public class RaisedState implements hasRamp{
    private hasRamp c;

    public RaisedState(hasRamp c) {
        this.c = c;
    }

    @Override
    public void lowerRamp() {
        c.lowerRamp();
    }

    @Override
    public void raiseRamp() {
        System.out.println("Kan inte lyfta mer, flaket är uppe!");
    }

    @Override
    public void setFlakState(hasRamp c) {
        this.c = c;
    }
}
