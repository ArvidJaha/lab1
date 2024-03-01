import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class drawImage extends JPanel {
    ;
    CarController cc = new CarController();
    public BufferedImage verkstad;
    public Verkstad<Volvo240> volvoVerkstad;

    public drawImage() {
        try {
         //   this.volvo = ImageIO.read(getClass().getResourceAsStream("pics/Volvo240.jpg"));
        //    this.Saab95 = ImageIO.read(getClass().getResourceAsStream("pics/Saab95.jpg"));
         //   this.scania = ImageIO.read(getClass().getResourceAsStream("pics/Scania.jpg"));
            this.verkstad = ImageIO.read(getClass().getResourceAsStream("pics/VolvoBrand.jpg"));
            this.volvoVerkstad = new Verkstad<>(20, new Point(500, 0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void moveit(GraphicsObject o, int x, int y) {
       o.position = new Point(x,y);
    }

    public void addCar(Car car) {
        if (car.getModelname().equals("Volvo240")) {
            cc.graphicCars.add(GraphicCars.graphicsVolvo());
        } else if (car.getModelname().equals("Saab95")) {
            cc.graphicCars.add(GraphicCars.graphicsSaab());
        } else if (car.getModelname().equals("Scania")) {
           cc.graphicCars.add(GraphicCars.graphicsScania());
        }
    }
}


