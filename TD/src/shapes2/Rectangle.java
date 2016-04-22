package shapes2;
import java.awt.Graphics;
import java.awt.geom.Point2D;

public class Rectangle extends Shape {

	private Point2D position;

	private double height;

	private double width;
	
	private class InternalPoint extends Point2D.Double{

		InternalPoint(Point2D p) {
			super(p.getX(), p.getY());
		}
		
		@Override
		public void setLocation(double x, double y) {
			super.setLocation(x, y);
			movingMessage();
		}
		
	}
	
	public Rectangle(Point2D p0, double height, double width) {
		super(p0, height, width);
		this.position = new InternalPoint(p0);
		this.height = height;
		this.width = width;
	}

	private void movingMessage() {
		System.out.println("moving to " + position.getX() + ", " + position.getY());
	}

	public Point2D position() {
		return (Point2D) position.clone();
	}

	public double height() {
		return height;
	}

	public double width() {
		return width;
	}

	public double area() {
		return width * height;
	}

	public double perimeter() {
		return 2 * (width + height);
	}

	public void move(double dx, double dy) {
		position.setLocation(position.getX() + dx, position.getY() + dy);
	}

	public void moveTo(Point2D newPosition) {
		position.setLocation(newPosition);
	}

	public String toString() {
		return "Rectangle " + position + ", height = " + height + ", width = " + width;
	}

	@Override
	public void rePaint(Graphics g) {
		g.drawRect((int)position.getX(), (int)position.getY(), (int)width, (int)height);
		
	}
}
