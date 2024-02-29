import javax.imageio.ImageIO;

public class GraphicCars {

    public GraphicsObject graphicsScania() {
        try {
            return new GraphicsObject(ImageIO.read(getClass().getResourceAsStream("pics/Scania.jpg")), CarFactory.createScania(0, 300));
        } catch (Exception e) {
            return null;
        }
    }
    public GraphicsObject graphicsVolvo() {
        try {
            return new GraphicsObject(ImageIO.read(getClass().getResourceAsStream("pics/Volvo240.jpg")), CarFactory.createVolvo(0, 0));
        } catch (Exception e) {
            return null;
        }
    }
    public GraphicsObject graphicsSaab() {
        try {
            return new GraphicsObject(ImageIO.read(getClass().getResourceAsStream("pics/Saab95.jpg")), CarFactory.createSaab(0, 150));
        } catch (Exception e) {
            return null;
        }
    }
}
