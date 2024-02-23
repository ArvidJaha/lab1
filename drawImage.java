import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawImage {

    BufferedImage volvo;
    BufferedImage saab;
    BufferedImage scania;
    BufferedImage verkstad;

    public drawImage() {
        try {
            volvo = ImageIO.read(getClass().getResourceAsStream("pics/Volvo240.jpg"));
            saab = ImageIO.read(getClass().getResourceAsStream("pics/Saab95.jpg"));
            scania = ImageIO.read(getClass().getResourceAsStream("pics/Scania.jpg"));
            verkstad = ImageIO.read(getClass().getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


