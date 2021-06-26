import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileWritingTest1 {
	public static void main(String[] args) {
		MyFileFrame mfm = new MyFileFrame();
		mfm.setVisible(true);
	}
}

class MyFileFrame extends JFrame implements ActionListener
{
	JLabel myLabel1 = new JLabel("Enter filename");
	JTextField filename = new JTextField(20); //enter file name here
	JLabel myLabel2 = new JLabel("Enter filedata");
	JTextArea fileData = new JTextArea(5,20); //enter file name here
	JButton save = new JButton("Save File");
	JButton clear = new JButton("Clear Data");
	
	MyFileFrame() {
		setLayout(new FlowLayout());
		setSize(350,250);
		add(myLabel1);add(filename);
		add(myLabel2);add(fileData);
		add(save);add(clear);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		save.addActionListener(this); //this means the current frame
		clear.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==save) {
			System.out.println("Save Button is clicked...");
			String theFilename = filename.getText();
			try {
				FileOutputStream fout = new FileOutputStream(theFilename);
				System.out.println("File is ready for writing....");
				String actualData = fileData.getText();
				byte byteArray[] = actualData.getBytes();
				fout.write(byteArray);
				JOptionPane.showMessageDialog(this, "File is created");
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showInternalMessageDialog(this, e.getMessage());
				e.printStackTrace();
			}
		}
		else if(arg0.getSource()==clear) {
			System.out.println("Clear Button is clicked...");
			filename.setText("");
			fileData.setText("");
		}
	}
}
