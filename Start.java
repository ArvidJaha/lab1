import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Start {
    CarView frame;
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
   private static GraphicCars gf = new GraphicCars();

    CarController cc = GraphicsFactory.createCC();

    public static void main(String[] args) {
        Start st = new Start();
   //     st.cc.graphicCars.add(gf.graphicsVolvo());
//        st.cc.cars.add(CarFactory.createScania(0,400));
//        st.cc.cars.add(CarFactory.createSaab(0, 200));


        // Start a new view and send a reference of self
        st.frame = GraphicsFactory.createCV("NYA Bilar filmen", st.cc);

        // Start the timer
        st.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (GraphicsObject o : cc.graphicCars) {
                o.modelCar.move();
                int x = (int) Math.round(o.modelCar.getxPos());
                int y = (int) Math.round(o.modelCar.getyPos());
                frame.drawPanel.images.addCar(o.modelCar);
//                frame.drawPanel.images.removeCar(car);
                frame.drawPanel.images.moveit(o, x, y);
                System.out.println(o.modelCar.getxPos());
                if(o.modelCar instanceof Scania) {
                    System.out.println(((Scania) o.modelCar).getRamp().getAngle());
                }
                if(o.modelCar instanceof Volvo240) {
                    cc.loadVolvo((Volvo240) o.modelCar, frame);
                }
                if (x > frame.drawPanel.getWidth() - 100) {
                    o.modelCar.setDirection(3);
                }
                if (x < 0) {
                    o.modelCar.setDirection(1);
                }
                else
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
            }
        }
    }

}
