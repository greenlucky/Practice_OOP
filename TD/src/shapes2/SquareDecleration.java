package shapes2;

import java.awt.geom.Point2D;

import shapes1.Rectangle;

public class SquareDecleration {
	
	Rectangle rec = null;

	public SquareDecleration(Point2D p0, double size){
		rec = new Rectangle(p0, size, size);
	}
	
	public Point2D position() {
		return rec.position();
	}

	public double height() {
		return rec.height();
	}

	public double width() {
		return rec.width();
	}

	public double area() {
		return rec.area();
	}

	public double perimeter() {
		return rec.perimeter();
	}

	public void move(double dx, double dy) {
		rec.move(dx, dy);
	}

	public void moveTo(Point2D newPosition) {
		rec.moveTo(newPosition);
	}

	public String toString() {
		return rec.toString();
	}
	
	
}
