import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawImage extends JPanel {
    public BufferedImage volvo;
    public BufferedImage Saab95;

    public BufferedImage scania;
    public BufferedImage verkstad;

    public drawImage() {
        try {
            this.volvo = ImageIO.read(getClass().getResourceAsStream("pics/Volvo240.jpg"));
            this.Saab95 = ImageIO.read(getClass().getResourceAsStream("pics/Saab95.jpg"));
            this.scania = ImageIO.read(getClass().getResourceAsStream("pics/Scania.jpg"));
            this.verkstad = ImageIO.read(getClass().getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


