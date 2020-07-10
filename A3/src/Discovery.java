import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Class Name: Discovery
 * 
 * Description: Write a JFrame with buttons
 * 
 */
public class Discovery extends JFrame{
    private JButton button;
    private JTextField textField;
    private JTextArea textArea;
    private final Color DEFAULT_COLOR_FOREGROUND = Color.WHITE;
    private final Color DEFAULT_COLOR_BACKGROUND = Color.ORANGE;
    private final int WINDOW_WIDTH = 720;  
    private final int WINDOW_HEIGHT = 480; 

    public Discovery(){
        initView();
        generalInit();
        add(button, BorderLayout.SOUTH);
        add(textField, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        setTitle("Discovery");
    }

    /**
      * Initialize the view 
      */
    private void initView(){
        button = new JButton("Button");
        textField = new JTextField("This is a textField!");
        textArea = new JTextArea("This is a textArea!");
        button.setToolTipText("This is a Tip!");
        button.setEnabled(false);
        button.setBackground(DEFAULT_COLOR_BACKGROUND);
        button.setForeground(DEFAULT_COLOR_FOREGROUND);
        textField.setEditable(false);
        textField.setBorder(BorderFactory.createLineBorder(DEFAULT_COLOR_BACKGROUND, 3));
    }

    /**
     * Initialize some general config
     */
    private void generalInit(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        new Discovery();
    }
}