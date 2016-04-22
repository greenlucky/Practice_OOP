package ShapesViewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.Random;
import java.awt.Toolkit;

import javax.swing.*;

import shapes2.Rectangle;
import shapes2.SquareAbstact;

public class ShapesViewer{
	
	private static String TITLE = "Shape Viewer";
	private static DessinZone dz;
	final Random rn = new Random();
		
	public ShapesViewer(){
		
	}
	
	private Component createButtonComponents(){
		
		/// Declare rectangle button
		JButton recButton = new JButton("Rectangle");
		recButton.setMnemonic(KeyEvent.VK_I);
		recButton.addActionListener(new rectangleButtonActionListener());
		
		/// Declare square button
		JButton squareButton = new JButton("Square");
		squareButton.setMnemonic(KeyEvent.VK_I);
		squareButton.addActionListener(new squareleButtonActionListener());
		
		/// Add Button to JFrame
		JPanel pane = new JPanel(new GridLayout(0,2,5,5));
		pane.add(recButton);
		pane.add(squareButton);
		
		return pane;
	}
	
	public Component createDessinZoneComponent(){
		
		Dimension d = new Dimension(500, 438);
		dz = new DessinZone();
		dz.setBorder(BorderFactory.createLineBorder(Color.black));
		dz.setBackground(Color.white);
		dz.setPreferredSize(d);
		
		return dz;
	}
	
	private static void createAndShowGUI(){
		
		JFrame sv = new JFrame(TITLE);
		sv.setSize(500, 500);
		sv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		//get screen dimension
		Dimension dim = tk.getScreenSize();
		
		//get position center screen 
		int xPos = (dim.width/2) - (sv.getWidth()/2);
		int yPos = (dim.height/2) - (sv.getHeight()/2);
		
		//set frame sv in center
		sv.setLocation(xPos, yPos);
		
		sv.setResizable(false);
		
		ShapesViewer app = new ShapesViewer();
		
		//add pane button
		Component buttons = app.createButtonComponents();
		sv.getContentPane().add(buttons, BorderLayout.SOUTH);
		
		//add pane DessinZone
		Component dessinZone = app.createDessinZoneComponent();
		sv.getContentPane().add(dessinZone, BorderLayout.NORTH);
		
		//Display the window
		sv.setVisible(true);
	}
	
	/**
	 * ActionListener for event button Rectangle's click event 
	 */
	public class rectangleButtonActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			dz.addShape(new Rectangle(new Point2D.Double(rn.nextInt(200), rn.nextInt(300)), rn.nextInt(200),rn.nextInt(300)));
			dz.repaint();		
		}
	}
	
	/**
	 * ActionListener for event button Rectangle's click event 
	 */
	public class squareleButtonActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0){
			dz.addShape(new SquareAbstact(new Point2D.Double(rn.nextInt(200), rn.nextInt(300)), rn.nextInt(200)));
			dz.repaint();
		}
	}
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
