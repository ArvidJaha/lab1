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

    // Just a single image, TODO: Generalize
    HashMap<Car, BufferedImage> carImages = new HashMap<>();
    HashMap<Car, Point> carPoints = new HashMap<Car, Point>();
    BufferedImage volvoWorkshopImage;

    // To keep track of a single car's position
    Point volvoPoint = new Point();
    Point saabPoint = new Point(0,200);
    Point scaniaPoint = new Point(0, 400);
    Point volvoWorkshopPoint = new Point(500,0);


    drawImage images = new drawImage();


    // TODO: Make this general for all cars
    void moveit(Car car, int x, int y) {
        carPoints.put(car, new Point(x,y));
    }
    public void addCar(Car car) {
        if (car.getModelname().equals("Volvo240")) {
            carImages.put(car, images.volvo);
            carPoints.put(car, volvoPoint);
        } else if (car.getModelname().equals("Saab95")) {
            carImages.put(car, images.saab);
            carPoints.put(car, saabPoint);
        } else if (car.getModelname().equals("Scania")) {
            carImages.put(car, images.scania);
            carPoints.put(car, scaniaPoint);
        }

        volvoWorkshopImage = images.verkstad;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        for (Car car : carImages.keySet()) {
            Point carPoint = carPoints.get(car);
            BufferedImage carImage = carImages.get(car);
            g.drawImage(carImage, carPoint.x, carPoint.y, null);
        }

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
