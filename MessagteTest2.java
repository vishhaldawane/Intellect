import javax.swing.JFrame;
import javax.swing.JTextField;

public class MessagteTest2 {
	public static void main(String[] args) {
		//3. create the object of the step number 1
		MyMessageFrame  m1 = new MyMessageFrame ("Ping",250,100,100,100);
		MyMessageFrame  m2 = new MyMessageFrame ("Pong",250,100,400,100);
		MyMessageFrame  m3 = new MyMessageFrame ("Pang",250,100,800,100);
		MyMessageFrame  m4 = new MyMessageFrame ("Pung",250,100,1000,100);
		
		m1.setVisible(true); //inherited from JFrame
		m2.setVisible(true); //inherited from JFrame
		m3.setVisible(true); //inherited from JFrame
		m4.setVisible(true); //inherited from JFrame
		
		Thread t1 = new Thread(m1);// m1 is of Runnable type
		Thread t2 = new Thread(m2);
		Thread t3 = new Thread(m3);
		Thread t4 = new Thread(m4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		/*m1.start(); //4 invoke start() to invoke run();
		m2.start(); //4 invoke start() to invoke run();
		m3.start(); //4 invoke start() to invoke run();
		m4.start(); //4 invoke start() to invoke run();
		*/
	}
}
class MyMessageFrame extends JFrame implements Runnable //1
{
	String message;
	JTextField messageLine = new JTextField(20);
	
	MyMessageFrame (String msg, int r, int c, int x, int y) {
		super(msg); //set the title..
		message=msg;
		add(messageLine); // put this on the Frame
		setSize(r,c);
		setLocation(x,y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//2
	public void run() { //mandate from Runnable
		//put your logic here which will participate in threading env
		for(int i=1;i<=1000;i++) {
			messageLine.setText(message+" "+i);
			
			 try { Thread.sleep(10); //wait for a second 
			 } 
			 catch (InterruptedException e)
			 
			 { e.printStackTrace(); }
			 
		}
	}
}
