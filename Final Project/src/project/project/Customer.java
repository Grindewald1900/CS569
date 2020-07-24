package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Customer extends JFrame implements ActionListener{
	
	private JLabeledTextBox lb;
	private DataBase db;
	private ResultSet rs;
	boolean edit=false;
	
	public Customer(DataBase db){
		super("Customer");
		lb = new JLabeledTextBox();	

		initForm();
		try{
			this.db = db;
			init();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		setVisible(true);
		pack();
		setResizable(false);
	}
	private void init(){
		 try{
		 	rs = db.executeQuery("Select * from customer");
		 }
		catch(Exception ex){
			System.out.println(ex.getMessage());
	    }	
		 moveFirst();		
	}
	private void moveNext(){
		lb.setValues(db.getNextRecord(rs));
	}
	private void moveFirst(){
		lb.setValues(db.getFirstRecord(rs));
	}
	private void movePrevious(){
		lb.setValues(db.getPreviousRecord(rs));
	}
	private void moveLast(){
		lb.setValues(db.getLastRecord(rs));
	}
	private void addButtons(){
		// Add your code here
	}
	public void actionPerformed(ActionEvent ev){
		// Add your code here

	}
	private void initForm(){
		// Add your code here
	}
	private void insert(){
		if(edit == false) {
			try{
				db.Insert("Customer",lb.getValues());
				JOptionPane.showMessageDialog(null,"Done successfully","Production Management",JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e.getMessage(),"Production Management",JOptionPane.ERROR_MESSAGE);
			}
			init();
		}
		else
			JOptionPane.showMessageDialog(null,"Duplicate Entry","Production Management",JOptionPane.ERROR_MESSAGE);

	}
	private void delete(){
		try{
			Statement state =db.getConnection().createStatement();
			state.executeUpdate("delete from customer where customer_id ='"+lb.getValue(0)+"'");
			JOptionPane.showMessageDialog(null,"Done successfully","Production Management",JOptionPane.INFORMATION_MESSAGE);
			//moveNext();
			init();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Production Management",JOptionPane.ERROR_MESSAGE);
		}
	}
	private void update(){
		try{
			Statement state =db.getConnection().createStatement();
			state.executeUpdate("update Customer set full_name_cs='"+lb.getValue(1)+"' where customer_id ='"+lb.getValue(0)+"'");
			state.executeUpdate("update Customer set address_cs='"+lb.getValue(2)+"' where customer_id ='"+lb.getValue(0)+"'");
			state.executeUpdate("update Customer set telephone_cs='"+lb.getValue(3)+"' where customer_id ='"+lb.getValue(0)+"'");
			JOptionPane.showMessageDialog(null,"Done successfully","Production Management",JOptionPane.INFORMATION_MESSAGE);
			///moveNext();
			init();
			edit = false;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Production Management",JOptionPane.ERROR_MESSAGE);
		}
	}

	
	public static void main(String []args){
		DataBase db = new DataBase(DataBase.MYSQL);
		db.openDatabase("//localhost:3306/store management","root","");
		new Customer(db);
	}
}