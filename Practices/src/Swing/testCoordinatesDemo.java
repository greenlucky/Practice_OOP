package Swing;

import javax.swing.SwingUtilities;
import Swing.CoordinatesDemo;

public class testCoordinatesDemo {
	
	public static void main(String[] args){
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				CoordinatesDemo cd = new CoordinatesDemo();
				cd.createAndShowGUI();
			}
		});
	}
	
}
