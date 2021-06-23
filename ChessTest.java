

abstract class Chess // Real game on the memory calculations
{
	//ASSUME : below methods are math calculations of this Game
	final void moveKnite() { //Horse - CAN NEVER BE HIDDEN NOW
		System.out.println("Moving in L Shape 2.5 steps");
	}
	void moveBishop() { // Camel
		System.out.println("Moving in diagonal bi-directional N steps");
	}
	void moveRook() { // Elephant
		System.out.println("Moving in vertical/horizontal bi-directional N steps");
	}
	void movePawn() { // The soldier
		System.out.println("Moving ahead 1 step or diagonal 1 step to kill");
	}
	
	void moveQueen() {
		System.out.println("Moving vertical/horizontal/diagonal bi-directional n steps");
	}
	void moveKing() {
		System.out.println("Moving anywhere 1 step");
	}
}

//final class = final version = no further inheritance
final class GraphicalChess extends Chess // actual game on the screen
{
	void moveGuiKnite() { //exclusive method
		super.moveKnite();
		System.out.println("Moving in V Shape 10 steps..in GUI way...");
	}
	//void moveKnite() { }
}
/*class AnotherGraphicalChess extends GraphicalChess
{
	
}*/
public class ChessTest {
	public static void main(String[] args) {
		GraphicalChess c = new GraphicalChess();
		c.moveKnite();
		c.moveGuiKnite();
	}
}
