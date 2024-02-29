import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class drawImage extends JPanel {

    public final HashMap<Car, BufferedImage> carImages = new HashMap<>();
    public final HashMap<Car, Point> carPoints = new HashMap<>();

    private BufferedImage volvo;
    private BufferedImage Saab95;
    private BufferedImage scania;
    public BufferedImage verkstad;
    public Verkstad<Volvo240> volvoVerkstad;

    public drawImage() {
        try {
            this.volvo = ImageIO.read(getClass().getResourceAsStream("pics/Volvo240.jpg"));
            this.Saab95 = ImageIO.read(getClass().getResourceAsStream("pics/Saab95.jpg"));
            this.scania = ImageIO.read(getClass().getResourceAsStream("pics/Scania.jpg"));
            this.verkstad = ImageIO.read(getClass().getResourceAsStream("pics/VolvoBrand.jpg"));
            this.volvoVerkstad = new Verkstad<Volvo240>(20, new Point(300,300));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void moveit(Car car, int x, int y) {
        carPoints.put(car, new Point(x,y));
    }

    public void addCar(Car car) {
        if (car.getModelname().equals("Volvo240")) {
            carImages.put(car, volvo);
            carPoints.put(car, car.getPosition());
        } else if (car.getModelname().equals("Saab95")) {
            carImages.put(car, Saab95);
            carPoints.put(car, car.getPosition());
        } else if (car.getModelname().equals("Scania")) {
            carImages.put(car, scania);
            carPoints.put(car, car.getPosition());
        }
    }
}


