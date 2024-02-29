import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    drawImage images = new drawImage();
    Point volvoWorkshopPoint = new Point(images.volvoVerkstad.getPosition().x,0);

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        for (Car car : images.carImages.keySet()) {
            Point carPoint = images.carPoints.get(car);
            BufferedImage carImage = images.carImages.get(car);
            g.drawImage(carImage, carPoint.x, carPoint.y, null);
        }

        Point pos = images.volvoVerkstad.getPosition();
        g.drawImage(images.verkstad, pos.x, pos.y, null);
    }
}
