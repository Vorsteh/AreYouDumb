import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class JFrameWindow {
    private final int MIN_X_BUTTON_POSITION = 50;
    private final int MAX_X_BUTTON_POSITION = 250;
    private final int MIN_Y_BUTTON_POSITION = 75;
    private final int MAX_Y_BUTTON_POSITION = 250;

    private final int windowHeight;
    private final int windowWidth;

    private final Font font;
    private final Font font1;

    public JFrame frame;
    public JButton mNoButton;
    public JButton mYesButton;
    public JTextField mTextField;


    Timer timer = new Timer();
    Random random = new Random();

    JFrameWindow(int width, int height){
        windowHeight = height;
        windowWidth = width;

        frame = new JFrame();
        mYesButton = new JButton("Ja");
        mNoButton = new JButton("Nej");
        mTextField = new JTextField("Är du trög?");
        font = new Font("SansSerif", Font.BOLD, 40);
        font1 = new Font("SansSerif", Font.BOLD, 33);

        setTextField();
        setButtons();
        setFrame();

        mYesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mTextField.setFont(font1);
                mTextField.setBounds(0, 100, 300, 50);
                mTextField.setText("Jag visste det! :3");
                mYesButton.setVisible(false);
                mNoButton.setVisible(false);
                startCountDown();
            }
        });
        mNoButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                int randomX = (int) Math.floor(Math.random()*(MAX_X_BUTTON_POSITION-MIN_X_BUTTON_POSITION+1)+MIN_X_BUTTON_POSITION);
                int randomY = (int) Math.floor(Math.random()*(MAX_Y_BUTTON_POSITION-MIN_Y_BUTTON_POSITION+1)+MIN_Y_BUTTON_POSITION);
                mNoButton.setLocation(randomX, randomY);
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new JFrameWindow(300, 300);
            }
        });
    }
    public void setTextField(){
        mTextField.setOpaque(false);
        mTextField.setBorder(BorderFactory.createEmptyBorder());
        mTextField.setHorizontalAlignment(JLabel.CENTER);
        mTextField.setBounds(0, 50, 300, 50);
        mTextField.setFont(font);
        mTextField.setFocusable(false);
    }
    public void setButtons(){
        mNoButton.setBounds(180, 200, 70, 35);
        mYesButton.setBounds(40, 200, 70, 35);

        mNoButton.setFocusable(false);
        mYesButton.setFocusable(false);

    }
    public void setFrame(){
        frame.getContentPane().add(mTextField);
        frame.add(mNoButton);
        frame.add(mYesButton);
        frame.setSize(windowWidth, windowHeight);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        int x = random.nextInt(500);
        int y = random.nextInt(500);
        frame.setLocation(x, y);
   }
    public void startCountDown(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.exit(MAX_X_BUTTON_POSITION);
            }
        }, 3 * 1000);
    }


}
