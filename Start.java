import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Start {
    CarView frame;
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    CarController cc = GraphicsFactory.createCC();

    public static void main(String[] args) {
        Start st = new Start();
        st.cc.cars.add(CarFactory.createVolvo(0,0));
        st.cc.cars.add(CarFactory.createScania(0,400));
        st.cc.cars.add(CarFactory.createSaab(0, 200));


        // Start a new view and send a reference of self
        st.frame = GraphicsFactory.createCV("CarSim 1.0", st.cc);

        // Start the timer
        st.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cc.cars) {
                car.move();
                int x = (int) Math.round(car.getxPos());
                int y = (int) Math.round(car.getyPos());
                frame.drawPanel.images.addCar(car);
                frame.drawPanel.images.moveit(car, x, y);
                System.out.println(car.getxPos());
                if(car instanceof Scania) {
                    System.out.println(((Scania) car).getRamp().getAngle());
                }
                if(car instanceof Volvo240) {
                    cc.loadVolvo((Volvo240) car, frame);
                }
                if (x > frame.drawPanel.getWidth() - 100) {
                    car.setDirection(3);
                }
                if (x < 0) {
                    car.setDirection(1);
                } else
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
            }
        }
    }

}
