package FinalExam;
import java.awt.BorderLayout;
import java.awt.Color;
// TODO clear
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JChatGUI extends JFrame implements ActionListener, KeyListener{
	
	private JListPanel usersList;
	private JTextArea messages;
	private JTextArea input;
	private JTextField jtf;
	public JChatGUI() {
		setTitle("JChatGUI");
		
		usersList = new JListPanel(15, 20,150);
		messages = new JTextArea(20, 50);
		messages.setEditable(false);
		input = new JTextArea(10, 40);
		jtf = new JTextField(20);
			
		JButton buttonAdd = new JButton("Add");
		JLabel labelNickname = new JLabel("Nickname");
		JPanel pTopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pCenterPanel = new JPanel();
		JPanel pRightPanel = new JPanel();
		JPanel pBottomPanel = new JPanel();
		ButtonPanel pRemoveClear = new ButtonPanel(new String[] {"Remove", "Clear"}, 1, 2);
		ButtonPanel pSendReset = new ButtonPanel(new String[] {"Send", "Reset"}, 1, 2);
		JScrollPane scrollMessage = new JScrollPane(messages);
		JScrollPane scrollInput = new JScrollPane(input);
		scrollMessage.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		scrollInput.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		
		pSendReset.setFixedSize(80, 80);
		pRightPanel.setLayout(new BoxLayout(pRightPanel, BoxLayout.Y_AXIS));
		usersList.setBorder(BorderFactory.createTitledBorder("List of users"));	
		messages.setBorder(BorderFactory.createLineBorder(Color.gray));
		input.setBorder(BorderFactory.createLineBorder(Color.gray));
		pCenterPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		buttonAdd.addActionListener(this);
		pRemoveClear.addActionListener(this);
		pSendReset.addActionListener(this);
		jtf.addKeyListener(this);
		messages.add(new JScrollPane());
		input.add(new JScrollPane());
		
		pTopPanel.add(labelNickname, "WEST");
		pTopPanel.add(jtf, "CENTER");
		pTopPanel.add(buttonAdd, "RIGHT");

		
		pRightPanel.add(usersList);
		pRightPanel.add(pRemoveClear);
		
		pCenterPanel.add(scrollMessage, BorderLayout.WEST);
		pCenterPanel.add(pRightPanel, BorderLayout.EAST);
		
		pBottomPanel.add(scrollInput, BorderLayout.WEST);
		pBottomPanel.add(pSendReset, BorderLayout.EAST);
		
		add(pTopPanel, BorderLayout.NORTH);
		add(pCenterPanel, BorderLayout.CENTER);
		add(pBottomPanel, BorderLayout.SOUTH);
		
		// To be completed
		
		pack();
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton)e.getSource();
		
		if(b.getText().equals("Add") && jtf.getText().length()>0) {
			usersList.addItem(jtf.getText());
			jtf.setText("");
		}
		if(b.getText().equals("Clear")) usersList.removeAllElements();
		if(b.getText().equals("Remove")) {
			usersList.removeItems(usersList.getSelectedElements());
		}
		if(b.getText().equals("Send")) {
			messages.append("\n"+input.getText());
			input.setText("");
		}		
		if(b.getText().equals("Reset")) {
			messages.setText("");
			input.setText("");
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		// To be completed
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		// To be completed
		if(e.getKeyCode() == KeyEvent.VK_ENTER && jtf.getText().length() > 0){
			usersList.addItem(jtf.getText());
			jtf.setText("");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JChatGUI();
	}




}
