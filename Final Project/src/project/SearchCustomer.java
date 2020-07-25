package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SearchCustomer extends JFrame implements KeyListener{
	
	JFlexGrid fg;
	JTextField tf;
	DataBase db;
	public SearchCustomer(DataBase db){
		super("Search Customers");
		this.db=db;
		tf= new JTextField(20);
		initFlexGrid();
		
		// Add your code here

		setVisible(true);
		pack();
	}
	public void initFlexGrid(){
		try{
			ResultSet rs = db.executeQuery("select * from customer;");

			int j=1;
			fg = new JFlexGrid(db.getRowCount(rs),db.getColumnCount(rs), true);
			fg.fill(rs);
			String s[]={"Customer ID","Full name","Address","Phone number"};
			fg.setTitles(s);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		// Add your code here
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// Add your code here
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		// Add your code here
	}
	public static void main(String []args){
		DataBase db = new DataBase(DataBase.MYSQL);
		db.openDatabase("//localhost:3306/store management","root","");
		new SearchCustomer(db);
	}

}