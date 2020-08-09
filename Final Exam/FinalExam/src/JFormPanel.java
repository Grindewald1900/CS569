import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFormPanel extends JPanel implements ActionListener{
	
	private ArrayList<JTextField> textList;
	private ArrayList<String[]> recordList;
	private int currentRecord;
	
	public JFormPanel(String []labels, String [][]records) {
		setLayout(new BorderLayout());
		
		textList = new ArrayList<JTextField>();
		recordList = new ArrayList<String[]>();
		currentRecord = 0;
		
		JPanel bpPanel = new JPanel(new GridLayout(2,1));
		ButtonPanel browseRecords = new ButtonPanel(new String[] {"First","Previous","Next","Last"});
		ButtonPanel processRecords = new ButtonPanel(new String[] {"New","Save","Edit","Delete"});
		processRecords.addActionListener(this);
		browseRecords.addActionListener(this);
		bpPanel.add(processRecords);
		bpPanel.add(browseRecords);
		add(bpPanel,"South");
		
		JPanel formPanel = new JPanel(new GridLayout(labels.length,1));
		
		for(int i=0;i<labels.length;i++) {
            JPanel pan = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JTextField textField = new JTextField(30);
            pan.add(textField);
            textList.add(textField); 
			// To be completed
			
			formPanel.add(pan);
		}
		
		add(formPanel,"Center");
		
		for(int i=0;i<records.length;i++) {
			recordList.add(records[i]);
		}
		
		displayRecord();
	}
	

	private void displayRecord() {
        for(int i=0; i<textList.size(); i++){
            textList.get(i).setText(recordList.get(currentRecord)[i]);
        }
		// To be completed
	}
	
	private void displayRecord(int record) {
        // To be completed
        currentRecord = record;
        displayRecord();
	}

	public void clear() {
        // To be completed
        for(int i=0; i<textList.size(); i++){
            textList.get(i).setText("");
        }
	}
	public void insert() {
        // To be completed
        String[] insertString = new String[textList.size()];
        for(int i=0; i<textList.size(); i++){
            insertString[i] = textList.get(i).getText();
        }
        recordList.add(insertString);
	}
	
	public void edit() {
        for(int i=0; i<textList.size(); i++){
            recordList.get(currentRecord)[i] = textList.get(i).getText();
        }
	}
	public void delete() {
        recordList.remove(currentRecord);
        movePrevious();
	}
	
	public void moveFirst() {
        currentRecord = 0;
        displayRecord(currentRecord);
	}
	
	public void moveLast() {
        currentRecord = recordList.size() - 1;
        displayRecord(currentRecord);
	}
	public void movePrevious() {
        // To be completed
        if(currentRecord >= 1){
            currentRecord --;
            displayRecord(currentRecord);
        }
	}
	public void moveNext() {
        // To be completed
        if(currentRecord < recordList.size() - 1){
            currentRecord ++;
            displayRecord(currentRecord);
        }
	}
	
	public void addKeyListenerAt(int index, KeyListener kl) {
        // To be completed
        textList.get(index).addKeyListener(kl);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton)e.getSource();

		if(b.getText().equals("New")){
			clear();
		}
		if(b.getText().equals("Save")){
			insert();
		}
		if(b.getText().equals("Delete")){
			delete();
		}
		if(b.getText().equals("Edit")){
			edit();
		}
		if(b.getText().equals("First")){
			moveFirst();
		}
		if(b.getText().equals("Previous")){
			movePrevious();
		}
		if(b.getText().equals("Next")){
			moveNext();
		}
		if(b.getText().equals("Last")){
			moveLast();
		}
	}
	
	
	public static void main(String []args) {
		JFrame frame = new JFrame();
		
		String []labels = {"First Name", "Last Name", "Age"};
		String [][]records = {
				{"Edward", "King", "26"},
				{"Philipe", "Legrand", "40"},
				{"Ernest", "Girard", "30"}
				};
		
		JFormPanel form = new JFormPanel(labels, records);
		frame.add(form);
		frame.pack();
		frame.setVisible(true);
	}
	

}
