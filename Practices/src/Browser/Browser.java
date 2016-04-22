package Browser;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;

public class Browser implements FrameController{
	
	public final static String MENU_FILE = "File";
	public final static String MENU_FILE_NEW = "new";
	public final static String MENU_FILE_CLOSE = "Close";
	public final static String MENU_FILE_QUIT = "Quit";
	public final static String DIALOG_QUIT_MSG = "Do you really";
	
	public final static String DIALOG_QUIT_TITLE = "Quit?";
	public final static String TITLE = "Browser";
	public final static String VERSION = "1.0.0";
	
	private static final List<JFrame> frames = new ArrayList<JFrame>();
	
	private static String initialPage = "https://google.com/";
	
	public static final String ICON = "images/Astrolabe.png";
	
	public void quit() {
		int answer = JOptionPane.showConfirmDialog(null, DIALOG_QUIT_MSG, DIALOG_QUIT_TITLE, JOptionPane.YES_NO_OPTION);
		if(answer == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}

	public JFrame createFrame() {
		JFrame frame = new BrowserFrame(this, initialPage);
		frame.setTitle(TITLE+" "+ VERSION);
		int pos = 30 * (frames.size() % 5);
		frame.setLocation(pos,pos);
		
		frame.setPreferredSize(new Dimension(960,720));
		frame.setIconImage(new ImageIcon(ICON).getImage());
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frames.add(frame);
		return frame;
	}

	public void deleteFrame(JFrame frame) {
		if(frames.size() > 1){
			frames.remove(frame);
			frame.dispose();
		}else{
			quit();
		}
	}
	
	public static void main(String[] args){
		
		if (args.length > 0)
			initialPage = args[0];

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Browser().createFrame();
			}
		});
	}
	
	
}
