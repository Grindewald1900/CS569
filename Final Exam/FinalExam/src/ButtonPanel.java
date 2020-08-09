

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
	public static final int FLOW_CENTER = 0;
	public static final int FLOW_LEFT = 1;
	public static final int FLOW_RIGHT = 2;
	public static final int BOX_VERT = 3;
	public static final int GRID = 4;
	public static final int VERTICAL = 5;

	
	private ArrayList<JButton> buttonList;
	
	public ButtonPanel(String []labels, int rows, int cols) {
		setLayout(new GridLayout(rows, cols));
		createButtons(labels);
	}
	public ButtonPanel(String []labels){
		createButtons(labels);
	}
	
	public ButtonPanel(String []labels, int layout) {
		switch(layout) {
			case FLOW_CENTER: setLayout(new FlowLayout()); break;
			case FLOW_LEFT: setLayout(new FlowLayout(FlowLayout.LEFT));break;
			case FLOW_RIGHT: setLayout(new FlowLayout(FlowLayout.RIGHT));break;
			case BOX_VERT: setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); break;
			case VERTICAL: setLayout(new GridLayout(labels.length,1)); break;
			case GRID: int rows = (int)Math.sqrt(labels.length);
					   int columns = (int)Math.ceil(labels.length/rows);
					   setLayout(new GridLayout(rows, columns));break;
		}
		
		/*
		if(layout==FLOW_CENTER) setLayout(new FlowLayout());
		else if(layout==FLOW_LEFT) setLayout(new FlowLayout(FlowLayout.LEFT));
		else if(layout==FLOW_RIGHT) setLayout(new FlowLayout(FlowLayout.RIGHT));
		else if(layout==BOX_VERT) setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		else if(layout==VERTICAL) setLayout(new GridLayout(labels.length,1));
		else if(layout==GRID) {
			int rows = (int)Math.sqrt(labels.length);
			int columns = (int)Math.ceil(labels.length/rows);
			setLayout(new GridLayout(rows, columns));
		}
		*/	
		
		createButtons(labels);
	}
	
	private void createButtons(String []labels) {
		buttonList = new ArrayList<JButton>();
		for(int i=0;i<labels.length;i++) {
			JButton b = new JButton(labels[i]);
			add(b);
			buttonList.add(b);
		}
	}
	
	public void addActionListener(ActionListener al) {
		for(int i=0;i<buttonList.size();i++) {
			JButton b = buttonList.get(i);
			b.addActionListener(al);
			//buttonList.get(i).addActionListener(al);
		}
	}
	
	public void setFixedSize(int width, int height) {
		Component LB[] = getComponents();
		for(int i=0;i<LB.length;i++)
			((JButton)LB[i]).setPreferredSize(new Dimension(width, height));
	}

}
