package shapes2;

import java.awt.Graphics;
import java.awt.geom.Point2D;

abstract public class Shape {
	
	public  Shape(Point2D p0, double height, double width){

	}
	
	public abstract Point2D position();
	
	public abstract double height();
	
	public abstract double width();
	
	public abstract double area();
	
	public abstract double perimeter();
	public abstract void move(double dx, double dy);
	
	public abstract void moveTo(Point2D newPosition);
	
	public abstract String toString();
	
	public abstract void rePaint(Graphics g);
}