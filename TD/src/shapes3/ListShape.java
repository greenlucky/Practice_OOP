package shapes3;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


import shapes2.Shape;
import shapes2.SquareAbstact;
import shapes2.Rectangle;

public class ListShape {
	public static void main(String[] args){
		
		//Propose a solution to create a List in Test in which you may put instances 
		//of Rectangle or Square, but no other type of object.
		List<Shape> l = new ArrayList<Shape>();
		
		Point2D p0 = new Point2D.Double(5, 2);
		
		l.add(new SquareAbstact(p0, 5));
		l.add(new Rectangle(p0, 5, 5));
		
	}
}
