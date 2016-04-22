package ShapesViewer;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import shapes2.Shape;

public class DessinZone extends JPanel {
	
	private List<Shape> shapeList;
	
	/*
	 * Create the panel
	 */
	public DessinZone(){
		shapeList = new ArrayList<Shape>();
	}
	
	/*
	 * add list shape to list
	 */
	public void setShapeList(List<Shape> l){
		this.shapeList = l;
	}
	
	/*
	 * Add shape item to shape list
	 */
	public void addShape(Shape shape){
		this.shapeList.add(shape);
	}
	
	
	/*
	 * Paint component(non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(shapeList != null){
			for(int i = 0; i < shapeList.size(); i++){
				Shape f = (Shape) shapeList.get(i);
				f.rePaint(g);
			}
		}
	}
}
