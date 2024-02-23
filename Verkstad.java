import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Verkstad<T extends Car> {
    private List<T> verkstaden;
    private final Point position;
    private final int maxCapacity;


    public Verkstad(final int maxCapacity, Point position) {
        this.verkstaden = new ArrayList<>();
        this.position = position;
        this.maxCapacity = maxCapacity;
    }

    public int getCapacity() {return verkstaden.size();}
    public Point getPosition () { return position; }
    public void add(T car) {
        if (verkstaden.size() <= maxCapacity) {
            verkstaden.add(car);
        }
        else throw new IllegalArgumentException("verkstaden är full");
     }

    public void remove(T car) {
        if(!verkstaden.isEmpty()) {
            verkstaden.remove(car);
        }
        else throw new IllegalArgumentException("verkstaden är tom");
    }
}
