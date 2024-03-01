import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class RandomCar {
    private final Random generator = new Random();
    private ArrayList<GraphicsObject> graphicsObjects = new ArrayList<>();
    private int i;
    public RandomCar() {
        this.graphicsObjects.add(GraphicCars.graphicsVolvo());
        this.graphicsObjects.add(GraphicCars.graphicsSaab());
        this.graphicsObjects.add(GraphicCars.graphicsScania());
        this.i = generator.nextInt(graphicsObjects.size());
    }

    public GraphicsObject createCar () {
        return graphicsObjects.get(i);
    }
}



