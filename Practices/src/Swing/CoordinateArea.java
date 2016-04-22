package Swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

public class CoordinateArea extends JComponent implements MouseInputListener{

	Point point = null;
	CoordinatesDemo controller;
	Dimension preferredSize = new Dimension(400, 75);
	Color gridColor;
	
	public CoordinateArea(CoordinatesDemo controller){
		this.controller = controller;
		
		//Add a border of 5 pixels at the left and bottom
		//and 1 pixel at the top and right
		setBorder(BorderFactory.createMatteBorder(1, 5, 5, 1, Color.RED));
		
		addMouseListener(this);
		addMouseMotionListener(this);
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setOpaque(true);
	}
	
	public Dimension getPreferredSize(){
		return preferredSize;
	}
	
	protected void paintComponent(Graphics g){
		//Paint background if we're opaque
		if(isOpaque()){
			g.setColor(getBackground());
			g.fillRect(0, 0, getWidth(), getHeight());
			
			//Paint 20x20 grid.
			g.setColor(Color.GRAY);
			drawGrid(g, 20);
			
			//If user has chosen a point, paint a small dot on
			if(point != null){
				g.setColor(getForeground());
				g.fillRect(point.x-3, point.y-3, 7, 7);
			}
		}
	}
	
	private void drawGrid(Graphics g, int gridSpace) {
		Insets insets = getInsets();
		int firstX = insets.left;
		int firstY = insets.top;
		int lastX = getWidth() - insets.right;
		int lastY = getWidth() - insets.bottom;
		
		//Draw vertical lines
		int x = firstX;
		while(x < lastX){
			g.drawLine(x, firstY, x, lastY);
			x += gridSpace;
		}
		
		int y = firstY;
		while(y < lastY){
			g.drawLine(firstX, y , lastX, y);
			y += gridSpace;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if(point == null){
			point = new Point(x, y);
		}else{
			point.x = x;
			point.y = y;
		}
		controller.updateClickPoint(point);
		repaint();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {	
		controller.updateCursorLocation(e.getX(), e.getY());
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {	
		controller.resetLabel();
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {	}

	@Override
	public void mousePressed(MouseEvent arg0) {	}

	@Override
	public void mouseReleased(MouseEvent arg0) { }

	@Override
	public void mouseDragged(MouseEvent arg0) {	}

	

}
