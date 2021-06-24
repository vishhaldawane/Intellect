
public class MessagteTest {
	public static void main(String[] args) {
		//3. create the object of the step number 1
		MyMessage m1 = new MyMessage("Ping");
		MyMessage m2 = new MyMessage("\tPong");
		MyMessage m3 = new MyMessage("\t\tPang");
		MyMessage m4 = new MyMessage("\t\t\tPung");
		
		m1.start(); //4 invoke start() to invoke run();
		m2.start(); //4 invoke start() to invoke run();
		m3.start(); //4 invoke start() to invoke run();
		m4.start(); //4 invoke start() to invoke run();
		
	}
}
class MyMessage extends Thread //1
{
	String message;
	
	MyMessage(String msg) {
		message=msg;
	}
	//2
	public void run() {
		//put your logic here which will participate in threading env
		for(int i=1;i<=10;i++) {
			System.out.println(message+" "+i);
			try {
				Thread.sleep(1000); //wait for a second
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
