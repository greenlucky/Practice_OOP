package Swing;

import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import Swing.SwingApplication;

public class testSwingApplication extends SwingApplication {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				try {
					createAndShowGUI();
				} catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
		});
	}
}
