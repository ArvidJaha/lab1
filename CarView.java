import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    private BunAction bunAc;
    public DrawPanel drawPanel;
    private JPanel controlPanel = new JPanel();
    private JPanel gasPanel = new JPanel();
    private JSpinner gasSpinner = new JSpinner();
    private JLabel gasLabel = new JLabel("Amount of gas");

    // Constructor
    public CarView(String framename, CarController carC){
        this.bunAc = new BunAction(carC);
        this.drawPanel = GraphicsFactory.createDP(X, Y-240);
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                bunAc.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(bunAc.gasButton, 0);
        controlPanel.add(bunAc.turboOnButton, 1);
        controlPanel.add(bunAc.liftBedButton, 2);
        controlPanel.add(bunAc.brakeButton, 3);
        controlPanel.add(bunAc.turboOffButton, 4);
        controlPanel.add(bunAc.lowerBedButton, 5);
        controlPanel.add(bunAc.addCarButton, 6);
        controlPanel.add(bunAc.removeCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        controlPanel.setBackground(Color.WHITE);
        this.add(controlPanel);

        bunAc.addCarButton.setBackground(Color.YELLOW);
        bunAc.removeCarButton.setBackground(Color.RED);
        bunAc.startButton.setBackground(Color.blue);
        bunAc.startButton.setForeground(Color.white);
        bunAc.startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(bunAc.startButton);

        bunAc.stopButton.setBackground(Color.red);
        bunAc.stopButton.setForeground(Color.black);
        bunAc.stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(bunAc.stopButton);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}