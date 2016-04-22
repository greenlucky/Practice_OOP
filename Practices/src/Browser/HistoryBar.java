package Browser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JToolBar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

public class HistoryBar extends JToolBar implements Observer {

	public static final String ICON_DIRECTORY = "images";
	
	public static final String BUTTON_PREVIOUS_ICON = ICON_DIRECTORY + File.separator + "HorizontalPrevious.png";
	public static final String BUTTON_PREVIOUS_TOOLTIP = "Go prevoius";
	
	public static final String BUTTON_NEXT_ICON = ICON_DIRECTORY + File.separator + "HorizontalNext.png";
	public static final String BUTTON_NEXT_TOOLTIP = "Go next";
	
	protected JButton prevButton;
	
	protected JButton nextButton;
	
	protected JTextField text;
	
	protected History<String> history;
	
	protected int index = 0;
	
	public HistoryBar(History<String> history) {
		
		this.history = history;
		history.addObserver(this);
		
		prevButton = new JButton(BUTTON_PREVIOUS_TOOLTIP);
		prevButton.setBorder(BorderFactory.createRaisedBevelBorder());
		prevButton.setToolTipText(BUTTON_PREVIOUS_TOOLTIP);
		
		nextButton = new JButton(BUTTON_NEXT_TOOLTIP);
		nextButton.setBorder(BorderFactory.createRaisedBevelBorder());
		nextButton.setToolTipText(BUTTON_NEXT_TOOLTIP);
		
		text = new JTextField();
		text.setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createLoweredBevelBorder(), 
						BorderFactory.createEmptyBorder(0, 2, 0, 5)
					));
		text.setEditable(true);
		
		text.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				HistoryBar.this.setText(text.getText());
			}
		});
		
		prevButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				HistoryBar.this.history.backward();
			}
		});
		
		nextButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				HistoryBar.this.history.forword();
			}
		});
		
		add(prevButton);
		add(nextButton);
		add(text);
	}

	protected void setText(String s) {
		history.add(s);
	}

	@Override
	public void update(Observable o, Object arg1) {
		if(! o.equals(history))
			return;
		String oldText = text.getText();
		String newText = history.get();
		System.out.println(text.getText());
		if(! newText.equals(oldText)){
			text.setText(newText);
		}
		
		nextButton.setEnabled(!history.atLast());
		prevButton.setEnabled(!history.atFirst());
		
	}

}
