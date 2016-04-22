package shapes4;

import java.awt.geom.Point2D;

public class testShapes4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangle rec = new Rectangle(new Point2D.Double(10, 10), 5, 5);
		
		Point2D p = rec.position();
		p.setLocation(20, 20);
		
		p.setLocation(10, 20);
	}

}
