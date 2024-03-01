import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicsObject {
    BufferedImage image;
    Car modelCar;
    Point position;

     public GraphicsObject(BufferedImage image, Car modelCar) {
         this.image = image;
         this.modelCar = modelCar;
         this.position = new Point();
     }

    public double getx(){
         return modelCar.getxPos();
     }
     public double gety(){
         return modelCar.getyPos();
     }
}
