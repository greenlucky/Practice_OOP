package shapes2;
import java.awt.geom.Point2D;

public class testSquare {
	public static void main(String[] args){
		
		Point2D p0 = new Point2D.Double(2,4);
		
		SquareDecleration sq = new SquareDecleration(p0, 5);
		
		//print square
		System.out.println(sq);
	}
}
