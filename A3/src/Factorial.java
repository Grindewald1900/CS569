import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;

/**
 * Class Name: Factorial
 * 
 * Description： A program to calculate the factorial of an integer entered in a text field. The entry must be restarted 
 * if the integer is greater than or equal to 17.
 * 
 */
public class Factorial extends JFrame{
    private GridLayout gridLayout;
    private JPanel flow1, flow2, flow3;
    private JTextField textField;
    private JTextArea textArea1, textArea2;
    private JButton button;

    private final int WINDOW_WIDTH = 400;  
    private final int WINDOW_HEIGHT = 145; 

    /**
     * Constructor
     */
    public Factorial(){
        initView();
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(flow1);
        add(flow2);
        add(flow3);
        setTitle("Factorial form");
        setVisible(true);
        setLocationRelativeTo(null);
    }

     /**
      * Initialize the view with some JPanels
      */
    private void initView(){
        gridLayout = new GridLayout(3,1);
        setLayout(gridLayout);
        flow1 = new JPanel();
        flow2 = new JPanel();
        flow3 = new JPanel();
        textArea1 = new JTextArea("Enter a number:");
        textArea2 = new JTextArea("Result :");
        textField = new JTextField(10);
        button = new JButton("Compute");

        textArea1.setOpaque(false);
        textArea2.setOpaque(false);
        textArea1.setFont(textArea1.getFont().deriveFont(Font.BOLD, 12f));
        textArea2.setFont(textArea1.getFont().deriveFont(Font.BOLD, 12f));
        button.setAlignmentX(FlowLayout.RIGHT);
        button.addActionListener(new ButtonListener());
        flow1.setLayout(new FlowLayout());
        flow2.setLayout(new FlowLayout());
        flow3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        flow1.add("textArea1", textArea1);
        flow1.add("textField", textField);
        flow2.add("textArea2", textArea2);
        flow3.add("button", button);
    }

    /**
     * Calculate the factorial of a given number
     * 
     * @param num the given number to be calculated
     * @return A String type of factorial
     * 
     */
    private String calculate(int num){
        // BigInteger is used to figure out big integers calculation
        BigInteger fac = new BigInteger("1");        
        for(int i=1; i<=num; i++){
            fac = fac.multiply(new BigInteger(Integer.toString(i)));
        }
        return fac.toString();
    }

    /**
     * Figure out if the given string is integer
     * 
     * @param str
     * @return
     * 
     */
    public static boolean isNumeric(String str){  
        for (int i = str.length();--i>=0;){     
            if (!Character.isDigit(str.charAt(i))){  
                return false;  
            }  
        }  
        return true;  
    }  

    /**
     * Inner class which deal with the click events of the button
     */
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            // If input is a number
            if(!isNumeric(textField.getText())){
                textArea2.setText("Result:  Error!!");
                JOptionPane.showMessageDialog(null, "The input should be a integer", "The input is invalid", JOptionPane.ERROR_MESSAGE);
            }else{
                int n = Integer.valueOf(textField.getText());
                // If input is valid
                if(n<0 || n >16){
                    textArea2.setText("Result:  Error!!");
                    JOptionPane.showMessageDialog(null, "The number must be between 0 and 16", "The input is invalid", JOptionPane.ERROR_MESSAGE);
                }else{
                    textArea2.setText("Result:  " + calculate(n));
                    button.setText(Integer.toString(n)+"!");
                }
            } 
        }
    }

    public static void main(String[] args){
        new Factorial();
    }
}