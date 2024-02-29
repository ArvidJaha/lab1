import java.awt.image.BufferedImage;

public class GraphicsObject {
    BufferedImage image;
    Car modelCar;

     public GraphicsObject(BufferedImage image, Car modelCar) {
         this.image = image;
         this.modelCar = modelCar;
     }

     double getx(){
         return modelCar.getxPos();
     }
     double gety(){
         return modelCar.getyPos();
     }
}
