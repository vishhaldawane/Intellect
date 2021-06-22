class Doctor {
	void diagnose() { System.out.println("Doctor: diagnosing ENT.."); }
}
class Surgeon  extends Doctor {
	void diagnose() { System.out.println("Surgeon: diagnosing xray....");}
}// hidding the method of its parent
class HeartSurgeon  extends Doctor {
	void diagnose() { System.out.println("HeartSurgeon: diagnosing ECG..");}
}
public class FunctionOverridingTest {//polymorphism - late binding
	public static void main(String[] args) {
		Doctor d = new Doctor();	d.diagnose();//compile-time binding with Doctor
		d = new Surgeon();	d.diagnose(); // real overriding - hiding the method of its nearest parent
		d = new HeartSurgeon(); d.diagnose();
	}
}
