package shapes1;

import java.awt.geom.Point2D;

public class testShapes {

	public static void main(String[] args) {
		Point2D p0 = new Point2D.Float(0, 0);
		//declare Rectangle
		Rectangle rec = new Rectangle( p0, 2, 5);
		
		//Print the rectangle
		System.out.println(rec);
		
		//move to x 10 point
		rec.move(10, 5);
		
		//Print the rectangle
		System.out.println(rec);
		
		//move to new point
		p0 = new Point2D.Float(5,5);
		rec.moveTo(p0);
		
		System.out.println(rec);
				
		
	}

}
