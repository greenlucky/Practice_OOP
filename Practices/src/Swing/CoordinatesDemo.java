package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

/**
 * 
 * @author Mr Lam
 * @version 1.0.0
 * @category OOP examples
 * 
 */

/*
 * This displays a framed area. As the user moves the cursor
 * over the area, a label displays the cursor's location. When
 * the user clicks, the area displays a 7x7 dot at the click 
 * location
 */

public class CoordinatesDemo {
	private JLabel label;
	private Point clickPoint, cursorPoint;
	
	private void buildUI(Container container){
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		
		CoordinateArea coordinateArea = new CoordinateArea(this);
		container.add(coordinateArea);
		
		label = new JLabel();
		resetLabel();
		container.add(label);
		
		//Align the left edges of the components.
		coordinateArea.setAlignmentX(Component.LEFT_ALIGNMENT);
		label.setAlignmentX(Component.LEFT_ALIGNMENT); //redundant
	}

	/**
	 * Create the GUI and show it. For thread safety,
	 * this method should be invoked from the event-
	 * dispatching thread
	 */
	public void createAndShowGUI(){
		//Create and set up the window.
		JFrame frame = new JFrame("CoordinatesDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//get dimension of screen
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		
		//get middle coordinate of screen 
		int xPos = (dim.width/2) - (frame.getWidth()/2);
		int yPos = (dim.height/2) - (frame.getHeight()/2) - 100;
		
		//set position 
		frame.setLocation(xPos, yPos);
		
		//Set up the content pane
		CoordinatesDemo controller = new CoordinatesDemo();
		controller.buildUI(frame.getContentPane());
		
		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public void updateClickPoint(Point p) {
		clickPoint = p;
		updateLabel();
	}
	
	public void updateCursorLocation(int x, int y) {
		
		if(x < 0 || y < 0){
			cursorPoint = null;
			updateLabel();
			return;
		}
		
		if(cursorPoint == null){
			cursorPoint = new Point();
		}
		
		cursorPoint.x = x;
		cursorPoint.y = y;
		updateLabel();
	}
	
	void resetLabel() {
		cursorPoint = null;
		updateLabel();
	}
	
	private void updateLabel() {
		String text = "";
		
		if((clickPoint == null) && (cursorPoint == null)){
			text = "Click or move the cursor within the framed area.";
		}else{
			if(clickPoint != null){
				text += "The last click was at ("+ clickPoint.x + ", "+ clickPoint.y+").";
			}
			
			if(cursorPoint != null){
				text += "The cursor is at ("+ cursorPoint.x + ", "+ cursorPoint.y+").";
			}
		}
		
		label.setText(text);
	}
	
}


