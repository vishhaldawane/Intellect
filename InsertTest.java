import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class  InsertTest {
	public static void main(String[] args) {
		MyFileFrame mfm = new MyFileFrame();
		mfm.setVisible(true);
	}
}

class MyFileFrame extends JFrame implements ActionListener
{
	JLabel myLabel1 = new JLabel("Enter emp number");
	JTextField empNumber= new JTextField(20); //enter file name here
	
	JLabel myLabel2 = new JLabel("Enter emp name  ");
	JTextField empName = new JTextField(20); //enter file name here
	
	JLabel myLabel3 = new JLabel("Enter emp job   ");
	JTextField empJob = new JTextField(20); //enter file name here
	
	JLabel myLabel4 = new JLabel("Enter emp mgr   ");
	JTextField empMgr = new JTextField(20); //enter file name here
	
	
	JLabel myLabel5 = new JLabel("Enter emp doj   ");
	JTextField empDoj = new JTextField(20); //enter file name here
	
	JLabel myLabel6 = new JLabel("Enter emp sal   ");
	JTextField empSalary = new JTextField(20); //enter file name here
	
	JLabel myLabel7 = new JLabel("Enter emp comm  ");
	JTextField empComm = new JTextField(20); //enter file name here
	
	JLabel myLabel8 = new JLabel("Enter emp deptno");
	JTextField empDeptno= new JTextField(20); //enter file name here
	
	JButton save = new JButton("INSERT");
	JButton clear = new JButton("Clear Data");
	
	MyFileFrame() {
		setLayout(new FlowLayout());
		setSize(350,250);
		add(myLabel1); add(empNumber);
		add(myLabel2); add(empName);
		add(myLabel3); add(empJob);
		add(myLabel4); add(empMgr);
		add(myLabel5); add(empDoj);
		add(myLabel6); add(empSalary);
		add(myLabel7); add(empComm);
		add(myLabel8); add(empDeptno);
		
		add(save);add(clear);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		save.addActionListener(this); //this means the current frame
		clear.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==save) {
			System.out.println("Insert Button is clicked...");
 
			try {
					//1 load the driver...
					System.out.println("Trying to load the driver ...");
					DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
					System.out.println("Driver loaded...");

					//2
					System.out.println("Trying to connect to the database...");
														//url							username	password
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:OSE", "system", "manager");
					System.out.println("Connected to the database..."+conn);

					PreparedStatement pst = conn.prepareStatement("insert into emp values (?,?,?,?,?,?,?,?)");
					
					
					int eno = Integer.parseInt(empNumber.getText());
					
					String ename = empName.getText();
					
					String job = empJob.getText();
					
					int mgr = Integer.parseInt(empMgr.getText());
					
					String date = empDoj.getText();
					java.util.Date doj = new SimpleDateFormat("yyyy-MM-dd").parse(date);
					System.out.println("DOJ "+doj);
					java.sql.Date joining = new java.sql.Date(doj.getTime());
					
					System.out.println("JOINING : "+joining);
					
					float sal = Float.parseFloat(empSalary.getText());
					float comm = Float.parseFloat(empComm.getText());
					
					int dno = Integer.parseInt(empDeptno.getText());
					
					pst.setInt(1,eno);
					pst.setString(2,ename);
					pst.setString(3,job);
					pst.setInt(4,mgr);
					pst.setDate(5,joining);
					pst.setFloat(6,sal);
					pst.setFloat(7,comm);
					pst.setInt(8,dno);
					
					pst.executeUpdate(); //HIT THE INSERT QUERY NOW
					JOptionPane.showMessageDialog(this, "Record is INSERTED");
					
					pst.close(); conn.close();
					
					System.out.println("DB resources closed...");

			} 
			 catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
				e.printStackTrace();
			}
		}
		else if(arg0.getSource()==clear) {
			System.out.println("Clear Button is clicked...");
		}
	}
}
