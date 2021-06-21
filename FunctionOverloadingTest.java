
class Tiger
{
	void jump()
	{
		System.out.println("Tiger is jumping....");
	}
	void jump(int length) //re-write it with same name 
	{
		System.out.println("Tiger is jumping....at length "+length+" meters");
	}
	void jump(float length) //re-write it with same name 
	{
		System.out.println("Tiger is jumping....at length "+length+" meters");
	}
	void jump(int length, int height) //re-write it with same name 
	{
		System.out.println("Tiger is jumping....at length "+length+" and height at "+height+" meters");
	}
	void jump(float length, float height) //re-write it with same name 
	{
		System.out.println("Tiger is jumping....at length "+length+" and height at "+height+" meters");
	}
	void jump(int length, float height) //re-write it with same name 
	{
		System.out.println("Tiger is jumping....at length "+length+" and height at "+height+" meters");
	}
	void jump(float length, int height) //re-write it with same name 
	{
		System.out.println("Tiger is jumping....at length "+length+" and height at "+height+" meters");
	}
}
public class FunctionOverloadingTest {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		t.jump(); //known at the compile time
		t.jump(7); //7 meters - known at the compile time
		t.jump(3, 5);
		t.jump(7.3f); 
		t.jump(4.3f,7.9f);
		t.jump(4.2f,10);
		t.jump(12,3.9f);
	}
}
