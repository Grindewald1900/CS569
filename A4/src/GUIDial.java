import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class GUIDial extends JFrame implements ActionListener, KeyListener {
	
	private JTextField textField;  // Input area
	private JButton button;
	private String savedPhoneNumber, textInput = ""; 
	private ButtonPanel panel1;
	private JPanel panel2;
	private String BIS = "Bis", RESET = "Reset", OK = "OK";
	
	public GUIDial() {
		/**Constructor */
		super();
		setTitle("The phone is ringing"); //We give a title to the application
		setSize(400,300); //We give a size to our window
		setLocationRelativeTo(null); //We center the window on the screen
		setResizable(false); //We forbid resizing of the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		
		setContentPane(buildContentPane());
		pack();
		setVisible(true);
	}
	
	private JPanel buildContentPane() {
		/**
		 * Part II
		 * Build a panal which include two Gridlayouts, the one in the North contains one Button and a textfield
		 * The other one contains a dial panel 
		 */
		//Initialize some components
		JPanel panel = new JPanel();
		panel1 = new ButtonPanel(new String[]{"1","2","3","4","5","6","7","8","9","Bis","0","Reset"}, 4, 3);
		panel2 = new JPanel();
		button = new JButton("OK");
		textField = new JTextField();
		//Register some listeners
		button.addActionListener(this);
		textField.addActionListener(this);
		textField.addKeyListener(this);
		panel1.addActionListener(this);
		//Combine the panels
		panel.setLayout(new BorderLayout());
		panel2.setLayout(new GridLayout(2, 1));
		panel2.add(textField);
		panel2.add(button);
		panel.add(panel2, BorderLayout.NORTH);
		panel.add(panel1, BorderLayout.SOUTH);		
		return panel;
	}

	private boolean isNumeric(String str){  
		/**Return true if the given string is a number */
        for (int i = str.length();--i>=0;){     
            if (!Character.isDigit(str.charAt(i))){  
                return false;  
            }  
        }  
        return true;  
	}  
	
	private boolean isStringEmpty(String str){
		/**Return false if the string pointer is null or the length is 0 */
		if(null != str && str.length() != 0){
			return false;
		}else{
			return true;
		}
	}

	private Boolean isKeyValid(char key){
		/**Return true if the input from keyyboard is a digit or carriage return*/
		//Notice: ASCII code for CR(carriage return) on 87-keys keyboard is 10, not 13  
		if((key>'0' && key<'9')){
			return true;
		}else if(key == 13){
			validateInputNumber();
		}
		return false;	
	}
	
	private void validateInputNumber() {
		/**Check if the input is valid or not and show the message  */
		textInput = textField.getText();
		if(textInput.length() == 10){
			savedPhoneNumber = textInput;
			textField.setText("Number called: " + textInput);
			// JOptionPane.showMessageDialog(null, "Number called: " + textInput, "Valid number", JOptionPane.INFORMATION_MESSAGE);
		}else{
			textField.setText("Please input a 10-digit number!");
			// JOptionPane.showMessageDialog(null, "Please input a 10-digit number!", "Invalid number", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void setTextField(String str, Boolean isClear){
		/**Clear or add character to the textfield  */
		textInput = isClear ? "" : textInput.concat(str);
		textField.setText(textInput);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/**Deal with button events from ActionListener */
		String content = e.getActionCommand();
		if(isNumeric(content)){
			setTextField(content, false);
		}else if(RESET.equals(content)){
			setTextField("", true);
		}else if(OK.equals(content)){
			validateInputNumber();
		}else if(BIS.equals(content)){
			if(isStringEmpty(savedPhoneNumber)){
				setTextField("", true);
			}else{
				textInput = savedPhoneNumber;
				textField.setText(textInput);
			}
		}

	}
	@Override
	public void keyTyped(KeyEvent e) {
		/**Deal with keyboard input events from KeyListener */
		char key = e.getKeyChar();
		if(!isKeyValid(key)){
			e.setKeyChar((char)0);
		}else{
			textInput = textInput.concat(String.valueOf(key));
		}		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//8 is ASCII code for backspace, override this method to forbid backspace of textfield
		if(e.getKeyChar() == 8){
			textField.setEditable(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//8 is ASCII code for backspace, override this method to forbid backspace of textfield
		if(e.getKeyChar() == 8){
			textField.setEditable(true);
		}
	}
	
	public static void main(String[] args) {
		new GUIDial();
	}

}
