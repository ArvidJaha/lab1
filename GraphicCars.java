import javax.imageio.ImageIO;
import java.util.Random;

public class GraphicCars {

    private static int getRandomY() {
        Random rand = new Random();
        return rand.nextInt(500);
    }



    public static GraphicsObject graphicsScania() {
        try {
            return new GraphicsObject(ImageIO.read(GraphicCars.class.getResourceAsStream("pics/Scania.jpg")), CarFactory.createScania(0, 200));
        } catch (Exception e) {
            return null;
        }
    }
    public static GraphicsObject graphicsVolvo() {
        try {
            return new GraphicsObject(ImageIO.read(GraphicCars.class.getResourceAsStream("pics/Volvo240.jpg")), CarFactory.createVolvo(0, 0));
        } catch (Exception e) {
            return null;
        }
    }
    public static GraphicsObject graphicsSaab() {
        try {
            return new GraphicsObject(ImageIO.read(GraphicCars.class.getResourceAsStream("pics/Saab95.jpg")), CarFactory.createSaab(0, 400));
        } catch (Exception e) {
            return null;
        }
    }
}
