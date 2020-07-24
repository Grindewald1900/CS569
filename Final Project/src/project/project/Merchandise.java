package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Merchandise extends JFrame implements ActionListener{
	
	private JLabeledTextBox lb;
	private DataBase db;
	private ResultSet rs,rs1;
	boolean modif=false;
	JListPanel l1;
	JListPanel l2,l3,l4;
	public Merchandise(DataBase db){
		super("Merchandise");
		lb = new JLabeledTextBox();	

		addButtons();
		try{
			this.db = db;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		initForm();
		init();
		setVisible(true);
		pack();
	}
	private void init(){
		 try{
		 	rs = db.executeQuery("Select * from merchandise");
		 	//rs.first();
		 }
		catch(Exception ex){
			System.out.println(ex.getMessage());
	    }	
		 moveFirst();		
	}
	private void moveNext(){
		lb.setValues(db.getNextRecord(rs));
		updateLists();
	}
	private void moveFirst(){
		lb.setValues(db.getFirstRecord(rs));
		updateLists();
	}
	private void movePrevious(){
		lb.setValues(db.getPreviousRecord(rs));
		updateLists();
	}
	private void moveLast(){
		lb.setValues(db.getLastRecord(rs));
		updateLists();
	}
	private void addButtons(){
		// Add your code here

	}
	private void initForm(){
		// Add your code here

	}
	public void actionPerformed(ActionEvent ev){
		// Add your code here

	}
	private JPanel createList1(){
		l1 = new JListPanel(5,20,100);
		l2 = new JListPanel(5,20,100);
		JButton select = new JButton(">>");
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				// Add your code here
			}
			});

		JButton retrieve = new JButton("<<");
		retrieve.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				// Add your code here
			}
			});
			JPanel p = new JPanel(new GridLayout(2,1));
			p.add(select);
			p.add(retrieve);
			JPanel pan = new JPanel(new FlowLayout(FlowLayout.CENTER));
			pan.add(l1);
			pan.add(p);
			pan.add(l2);
			
			pan.setBorder(BorderFactory.createTitledBorder("Raw material"));
		return pan;
	}
	private JPanel createList2(){
		l3 = new JListPanel(5,20,100);
		l4 = new JListPanel(5,20,100);
		JButton select = new JButton(">>");
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				// Add your code here
			}
			});
 
		JButton retrieve = new JButton("<<");
		retrieve.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				// Add your code here
			}
			});
			JPanel p = new JPanel(new GridLayout(2,1));
			p.add(select);
			p.add(retrieve);
			JPanel pan = new JPanel(new FlowLayout(FlowLayout.CENTER));
			pan.add(l3);
			pan.add(p);
			pan.add(l4);
			
			pan.setBorder(BorderFactory.createTitledBorder("Merchandise's Components"));
		return pan;
	}

	private void insert(){
		try{
			db.Insert("merchandise",lb.getValues());
			Object o[] = l4.getAllElements();
			for(int i=0;i<o.length;i++){
				db.executeUpdate("insert into compose_de values('"+lb.getValue(0)+"','"+o[i].toString()+"');");
			}
			Object o1[] = l2.getAllElements();
			for(int i=0;i<o1.length;i++){
				db.executeUpdate("insert into contient values('"+lb.getValue(0)+"','"+o1[i].toString()+"');");
			}
			JOptionPane.showMessageDialog(null,"Done","Production Management",JOptionPane.INFORMATION_MESSAGE);
			init();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Production Management",JOptionPane.ERROR_MESSAGE);
		}
		init();
	}
	private void delete(){
		try{
			Statement state =db.getConnection().createStatement();
			
			state.addBatch("delete from merchandise where reference='"+lb.getValue(0)+"'");
 
			JOptionPane.showMessageDialog(null,"Done","Production Management",JOptionPane.INFORMATION_MESSAGE);
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
			state.executeUpdate("update merchandise set desig='"+lb.getValue(1)+"' where reference='"+lb.getValue(0)+"'");
			state.executeUpdate("update merchandise set unit_price='"+lb.getValue(2)+"' where reference="+lb.getValue(0));
			state.executeUpdate("update merchandise set type='"+lb.getValue(3)+"' where reference='"+lb.getValue(0)+"'");
			JOptionPane.showMessageDialog(null,"Done","Production Management",JOptionPane.INFORMATION_MESSAGE);
			///moveNext();
			init();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Production Management",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void updateLists() {
		try{
			l1.removeAllElements();
			Statement state =db.getConnection().createStatement();
			ResultSet res = state.executeQuery
					("SELECT code_mat from rawmaterial");
			//rs.first();
			while(res.next()){
				l1.addItem(res.getString(1));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			l2.removeAllElements();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	
		try{
			l3.removeAllElements();
			Statement state =db.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet res = state.executeQuery("SELECT code_mat FROM rawmaterial");
			//res.first();
			while(res.next()){
				l3.addItem(res.getString(1));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			l4.removeAllElements();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String []args){
		DataBase db = new DataBase(DataBase.MYSQL);
		db.openDatabase("//localhost:3306/store management","root","");
		new Merchandise(db);
	}
}