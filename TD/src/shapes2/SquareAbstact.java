package shapes2;
import java.awt.Graphics;
import java.awt.geom.Point2D;


public class SquareAbstact extends Shape{
	
	private Point2D position;
	
	private double size;
		
	public SquareAbstact(Point2D p0, double size) {
		super(p0, size, size);
		
		this.position = (Point2D)p0.clone();
		this.size = size;
	}

	public Point2D position() {
		return (Point2D) position.clone();
	}

	public double height() {
		return this.size;
	}

	@Override
	public double width() {
		return this.size;
	}

	public double area() {
		return this.size*this.size;
	}

	@Override
	public double perimeter() {
		return 2*(size + size);
	}

	@Override
	public void move(double dx, double dy) {
		position.setLocation(position.getX() + dx, position.getY() + dy);
		
	}

	@Override
	public void moveTo(Point2D newPosition) {
		position.setLocation(newPosition);
		
	}

	@Override
	public String toString() {
		return "Square "+ position +", height = "+ size + ", width = "+ size;
	}

	public void rePaint(Graphics g) {
		g.drawRect((int)position.getX(), (int)position.getY(), (int)size, (int)size);
	}
	
	
}
