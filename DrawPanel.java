import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements CarObserver{
  private drawImage images = new drawImage();
  private HashMap<Car, BufferedImage> carImages = new HashMap<>();
  private HashMap<Car, Point> carPoints = new HashMap<>();
  private BufferedImage volvoWorkshopImage;
  Point volvoWorkshopPoint = new Point(500,0);

   public void moveit(Car car, int x, int y) {
        carPoints.put(car, new Point(x,y));
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
    }
    public void addCar(Car car) {
        if (car.getModelname().equals("Volvo240")) {
            carImages.put(car, images.volvo);
            carPoints.put(car, car.getPosition());
        } else if (car.getModelname().equals("Saab95")) {
            carImages.put(car, images.Saab95);
            carPoints.put(car, car.getPosition());
        } else if (car.getModelname().equals("Scania")) {
            carImages.put(car, images.scania);
            carPoints.put(car, car.getPosition());
        }

        volvoWorkshopImage = images.verkstad;
    }

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

   public void removeCar(Car car) {
       carImages.remove(car);
       carPoints.remove(car);
   }

    @Override
    public void update(Car car, boolean isRemovingCar) {
        if(isRemovingCar) {
            removeCar(car);
        }
        else {
            addCar(car);
        }
        repaint();
    }
}
