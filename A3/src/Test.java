import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

/**
 * Class Name: Test
 * 
 * Description:  Create a window containing a Test button and 3 normal buttons 
 * that will change the title of the window.
 * 
 */
public class Test extends JFrame{
    // private JButton button;
    private ButtonPanel panel;
    private final int WINDOW_WIDTH = 360;  
    private final int WINDOW_HEIGHT = 160; 

    public Test(){
        initView();
        generalInit();
        add(panel, BorderLayout.CENTER);
        setTitle("Test");
    }

    /**
      * Initialize the view 
      */
    private void initView(){
        panel = new ButtonPanel(new String[]{"Test", "One", "Two", "Three"});
        panel.addActionListener(new ButtonListener());
    }

    /**
      * Initialize some normal configuration
      */
    private void generalInit(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     * Inner class which deal with the click events of the button
     */
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String content = ((JButton)e.getSource()).getText();
            switch(content){
                case "Test":
                    System.out.println("Test click");
                    break;
                case "One":
                    setTitle("*One*");
                    break;
                case "Two":
                    setTitle("*Two*");
                    break;
                case "Three":
                    setTitle("*Three*");
                    break;
                default:
                    break;
            }
        }

    }

    public static void main(String[] args){
        new Test();
    }
    
}