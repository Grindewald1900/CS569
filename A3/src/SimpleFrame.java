import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Class Name: SimpleFrame
 * 
 * Description: Write a SimpleFrame class to display a window
 * 
 */
public class SimpleFrame extends JFrame{
    private JLabel label;
    private JButton button;
    private final String LABEL_CONTENT = "This is a label";
    private final String BUTTON_CONTENT = "OK";
    private final int WINDOW_WIDTH = 720;  
    private final int WINDOW_HEIGHT = 480; 


    public SimpleFrame(){
        generalInit();
        setTitle("SimpleFrame");
        //3. Then add a label to this window, representing a label (a short text).
        label = new JLabel(LABEL_CONTENT);
        //4. Center the label text using the setHorizontalAlignment method.
        label.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(label);
        button = new JButton(BUTTON_CONTENT);
        add(button, BorderLayout.SOUTH);
        
    }

    /**
      * Initialize some normal configuration
      */
      private void generalInit(){
        //1. Write a SimpleFrame class to display a window. We will simply give it a title and a size.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        //2. Change the default behavior of the window when it is closed so that the application is exited.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        new SimpleFrame();
    }
}