import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        st.frame = GraphicsFactory.createCV("NYA Bilar filmen", st.cc);
        st.cc.addObserver(st.frame.drawPanel);

        // Start the timer
        st.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car c : cc.cars) {
                c.move();
                int x = (int) Math.round(c.getxPos());
                int y = (int) Math.round(c.getyPos());
                frame.drawPanel.addCar(c);
//                frame.drawPanel.images.removeCar(car);
                frame.drawPanel.moveit(c, x, y);
                if(c instanceof Scania) {
                    System.out.println(((Scania) c).getRamp().getAngle());
                }
                if(c instanceof Volvo240) {
                    cc.loadVolvo((Volvo240) c,frame);
                }
                if (x > frame.drawPanel.getWidth() - 100) {
                    c.setDirection(3);
                }
                if (x < 0) {
                    c.setDirection(1);
                }
                else
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
            }
        }
    }

}
