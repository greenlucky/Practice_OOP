package Browser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class BrowserFrame extends JFrame implements Observer {

	public static final String LINK_OPEN_STRING = "Open";
	public static final String LINK_DEFAULT_STRING = " ";
	public static final String FAILURE_URL = "file:Failure.html";
	
	private JEditorPane pane;
	private HistoryBar toolbar;
	private History<String> history;
	private FrameController controller;
	
	// label to show links
	private JLabel label;
	
	/**
	 * The construct runs the browser. It displays the main
	 * frame with the fetched initialPage
	 * @param initialPage the first page to show
	 */
	
	public BrowserFrame(FrameController controller, String initialPage) {
		
		//set the controller
		this.controller = controller;
		
		//set up the editor pane
		pane = new JEditorPane();
		pane.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(pane);
		
		//label to show link
		label = new JLabel(LINK_DEFAULT_STRING);
		
		pane.addHyperlinkListener(new HyperlinkListener() {
			@Override
			public void hyperlinkUpdate(HyperlinkEvent evt) {
				
				//Link Active
				if(evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
					String selectedURL = evt.getURL().toString();
					history.add(selectedURL);
				}
			}
		});
				
		history = new History<String>();
		history.addObserver(this);
		toolbar = new HistoryBar(history);
		history.add(initialPage);
		
		//Menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("");
		menuBar.add(menu);
		
		//button new 
		createMenuItem(menu, Browser.MENU_FILE_NEW, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BrowserFrame.this.controller.createFrame();
			}
		});
		//separator 
		createMenuSeparator(menu);
				
		//button close frame
		createMenuItem(menu, Browser.MENU_FILE_CLOSE, new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				BrowserFrame.this.controller.deleteFrame(BrowserFrame.this);
			}
		});
		
		//close window browser
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				BrowserFrame.this.controller.deleteFrame(BrowserFrame.this);
			}
		});
		
		//separator
		createMenuSeparator(menu);
		
		createMenuItem(menu, Browser.MENU_FILE_QUIT, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				BrowserFrame.this.controller.quit();
			}
		});
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(toolbar, BorderLayout.NORTH);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		contentPane.add(label, BorderLayout.SOUTH);
		setContentPane(contentPane);
	}

	@Override
	public void update(Observable obs, Object arg) {
		if(!obs.equals(history)){
			return;
		}
		System.out.println(history.get());
		setPage(history.get());
	}
	
	protected void setPage(String url){
		try{
			pane.setPage(url);
		}catch(Exception e1){
			try{
				pane.setPage(FAILURE_URL);
			}catch(Exception e2){
				System.err.println(e2.getMessage());
			}
		}
	}
	
	public void createMenuItem(JMenu menu, String name, ActionListener action){
		JMenuItem menuItem = new JMenuItem(name);
		menuItem.addActionListener(action);
		menu.add(menuItem);
	}
	
	private void createMenuSeparator(JMenu menu){
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.lightGray);
		menu.add(separator);
	}
}
