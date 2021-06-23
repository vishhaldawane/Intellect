class Circle
{
	float radius;
	static final float PI=3.14f; //universal constant

	public Circle(float radius) {
		super();
		this.radius = radius;
	}
	void showCircle() {
		System.out.println("Circle radius : "+radius);
		float area =  PI * radius * radius;
		System.out.println("Circle Area   : "+area);
	}
}

class Car
{
	String modelName;
	final String numberPlate;
	
	Car(String mn, String np) {
		modelName=mn;
		numberPlate=np;
	}
	//Stillness is using you as an expression to develop any logic|music|express
	//Stillness speaks - no voice required | NO mouth | NO ear
	
	void showCar() {
		System.out.println("ModelName  : "+modelName);
		System.out.println("NumberPlate: "+numberPlate);
	}
}

public class FinalTest {
	public static void main(String[] args) {
		Circle c1 = new Circle(45.89f);
		Circle c2 = new Circle(35.19f);
		Circle c3 = new Circle(15.39f);
		
		c1.showCircle();
		c2.showCircle();
		c3.showCircle();
		System.out.println("--------");
		
		Car car1 = new Car("Honda","TN-01-8989");
		Car car2 = new Car("Skoda","UP-02-1989");
		Car car3 = new Car("Maruthi","MH-03-3949");
		
		car1.showCar();
		car2.showCar();
		car3.showCar();
		
		
	}
}
