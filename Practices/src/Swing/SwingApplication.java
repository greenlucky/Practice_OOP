package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingApplication implements ActionListener {
	
	//Declare constant label
	private static String labelPrefix = "Number of button clicks ";
	
	//Count quantity mouse click
	private int numClicks = 0;
	
	final JLabel label = new JLabel(labelPrefix + "0     ");
	
	//Secify the look and feel to use. valid values:
	//null (use the default), "Metal", "System", "Motif", "GTK+"
	final static String LOOKANDFEEL = null;
	
	public Component createComponents(){
		JButton button = new JButton("I'm a Swing button!");
		button.setMnemonic(KeyEvent.VK_I);
		button.addActionListener(this);
		label.setLabelFor(button);
		
		/*
		 * An easy way to put space between a top-level container and its
		 * contents is to put contents in a JPane that has an "empty"
		 * border
		 */
		JPanel pane = new JPanel(new GridLayout(0,1));
		pane.add(button);
		pane.add(label);
		pane.setBorder(BorderFactory.createEmptyBorder(
						30, //top
						30, //left
						10, //bottom
						30 //right
					));
		return pane;
	}
	
	
	private static void initLookAndFeel() throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		String lookAndFeel = null;
		
		if(LOOKANDFEEL != null){
			if(LOOKANDFEEL.equals("Metal")){
				lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
			}else if(LOOKANDFEEL.equals("System")){
				lookAndFeel = UIManager.getSystemLookAndFeelClassName();
			}else if(LOOKANDFEEL.equals("Motif")){
				lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
			}else if(LOOKANDFEEL.equals("GTK+")){
				lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
			}else{
				System.err.println("Unexpected value of LOOKANDFEEL specifield: "+ LOOKANDFEEL);
				lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
			}
			
			try{
				UIManager.setLookAndFeel(lookAndFeel);
			}catch(ClassNotFoundException e){
				System.err.println("Did you include the L&F library in the class path?");
				System.err.println("Using the default look and feel.?");
			}catch(UnsupportedLookAndFeelException e){
				System.err.println("Can't use the specified look and feel. ("+ lookAndFeel +") on this platform.");
				System.err.println("Using the default look and feel.");
			}catch(Exception e){
				System.err.println("Couldn't get specified look and feel.("+ lookAndFeel +"), for some reason.");
				System.err.println("Using the default look and feel.");
				e.printStackTrace();
			}
		}
		
		
	}
	
	/**
	 * Create the GUI and show it. For thread safety. this method should be
	 * invoked from the event-dispatching thread. 
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void createAndShowGUI() throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		//Set the look and feel
		initLookAndFeel();
		
		//Make sure we have nice window decoration
		JFrame.setDefaultLookAndFeelDecorated(true);
		//Create and set up the window
		JFrame frame = new JFrame("SwingApplication");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//get coordination of screen
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		//get dimension of screen
		Dimension dim = tk.getScreenSize();
		
		int xPos = (dim.width/2) - frame.getWidth()/2;
		int yPos = (dim.height/2) - frame.getHeight()/2;
		
		frame.setLocation(xPos, yPos);
		
		SwingApplication app = new SwingApplication();
		Component contents = app.createComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		//Display the window
		frame.pack();
		frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		numClicks++;
		label.setText(labelPrefix + numClicks);
	}
	
	
	
	
}
