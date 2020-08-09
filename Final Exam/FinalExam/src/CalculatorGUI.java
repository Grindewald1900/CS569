
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorGUI extends JFrame{
	
	public CalculatorGUI() {
		setTitle("Calculator GUI using Swing");
		JTextField tf = new JTextField(50);
		getContentPane().add(tf,"North");
		
		String operatorsAndOperands[] = {"(",")","%","AC","7","8","9","/","4","5","6","x",
				"1","2","3","-","0",".","=","+"};

		String []angular= {"Rad", "Deg", "Grad"};

		String []trigonometric= {"sin", "cos", "tan", "asin", "acos", "atan"};
		
		String []hyperbolic= {"sinh", "cosh", "tanh", "asinh", "acosh", "atanh"};
		
		String []others= {"log", "ln", "exp","inv", "pi", "e"};

		JPanel pan = new JPanel(new GridLayout(1,2));
		
		JPanel pLeft = new JPanel(new GridLayout(4,1));
		ButtonPanel pRight = new ButtonPanel(operatorsAndOperands, 5, 4);
		ButtonPanel pAngular = new ButtonPanel(angular, 1, 3);
		JPanel pTrigonometric = new ButtonPanel(trigonometric, 2, 3);
		JPanel pHyperbolic = new ButtonPanel(hyperbolic, 2, 3);
		JPanel pOthers = new ButtonPanel(others, 2, 3); 
		pRight.setBorder(BorderFactory.createTitledBorder("Operator and Operands"));
		pLeft.setBorder(BorderFactory.createTitledBorder("Functions"));
		pAngular.setBorder(BorderFactory.createTitledBorder("Angular"));
		pTrigonometric.setBorder(BorderFactory.createTitledBorder("Trigonometric"));
		pHyperbolic.setBorder(BorderFactory.createTitledBorder("Hyperbolic"));
		pOthers.setBorder(BorderFactory.createTitledBorder("Others"));
		
		pLeft.add(pAngular);
		pLeft.add(pTrigonometric);
		pLeft.add(pHyperbolic);
		pLeft.add(pOthers);
		
		pan.add(pLeft);
		pan.add(pRight);
		// add your code here

		getContentPane().add(pan, "Center");
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalculatorGUI();
	}

}
