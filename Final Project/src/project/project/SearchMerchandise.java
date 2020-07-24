package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.sql.*;

public class SearchMerchandise extends JFrame implements KeyListener{
	
	JFlexGrid fg;
	JTextField tf;
	DataBase db;
	public SearchMerchandise(DataBase db){
		super("Search Merchandise");
		this.db=db;
		tf= new JTextField(20);

		initJFlexGrid();
		
		// Add your code here

		setVisible(true);
		pack();
	}
	
	private void initJFlexGrid() {
		try{
			ResultSet rs = db.executeQuery("select * from merchandise;");
			int j=1;
			fg = new JFlexGrid(db.getRowCount(rs),db.getColumnCount(rs), true);
			fg.fill(rs);
			String s[]={"Reference","Designation","Unit Price","Type"};
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
		new SearchMerchandise(db);
	}
}