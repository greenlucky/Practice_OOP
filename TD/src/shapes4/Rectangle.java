package shapes4;

import java.awt.geom.Point2D;

public class Rectangle {

	private class Internal extends Point2D.Double{
		
		public Internal(Point2D p){
			super(p.getX(), p.getY());
		}
		
		public void setLocation(double x, double y) {
			super.setLocation(x, y);
			movingMessage();
		}
	}

	private Point2D position;

	private double height;

	private double width;

	public Rectangle(Point2D p0, double height, double width) {
		this.position = new Internal(p0);
		this.height = height;
		this.width = width;
	}
	
	private void movingMessage() {
		System.out.println("Move to x = " + position.getX() + ", y = " + position.getY());

	}
	
	public Point2D position() {
		return (Point2D) position;
	}

	public double height() {
		return this.height;
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

	

}
