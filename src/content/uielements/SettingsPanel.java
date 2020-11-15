package content.uielements;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import content.AppState;

public class SettingsPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -809738724939015369L;
	
    // A reference to the Main Frame
    private final MainFrame mainFrame;
	
	// Pen elements 
    private JSlider penSizeSlider;
    private JLabel penSizeLabel;
    private JLabel selectColorLabel;
    
    private final Set<ColorButton> colorButtons = new HashSet<>();
    private final JButton deleteButton = new JButton("Erase everything");;
    	
	
	public SettingsPanel(MainFrame main, String title) {
		this.mainFrame = main;
		
    	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS) );
    	this.setBackground(Color.WHITE);
    	this.setBorder(new TitledBorder(title));

    	this.build();  	
    	
	}
	
	public void build() {
		
    	this.penSizeSlider = new JSlider(
    			JSlider.HORIZONTAL, 
    			AppState.pen.getMinSize(), 
    			AppState.pen.getMaxSize(), 
    			AppState.pen.getSize()
    			); 

    	
    	this.penSizeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				AppState.pen.setSize(SettingsPanel.this.penSizeSlider.getValue());
			}
			
		});
    	
    	this.deleteButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
				SettingsPanel.this.mainFrame.getDrawPanel().deleteEverything();	
				SettingsPanel.this.mainFrame.getDrawPanel().repaint();
			}
		});
    	
    	this.selectColorLabel = new JLabel("Select a color");	
    	this.setupColorButtons();
    	
    	this.penSizeSlider.setPaintTicks(true);
    	this.penSizeLabel = new JLabel("Select pen size");
    	this.penSizeSlider.setMajorTickSpacing(2);
    	
    	this.add(Box.createVerticalStrut(25));
    	this.add(this.penSizeLabel);
    	this.add(Box.createVerticalStrut(10));
		this.add(this.penSizeSlider);
		this.add(Box.createVerticalStrut(10));
		this.add(this.selectColorLabel);
		this.add(Box.createVerticalStrut(10));
		
		//Adding all buttons to pEast
		for(ColorButton b : this.colorButtons) {
			this.add(b);
			this.add(Box.createVerticalStrut(5));
		}	
		
		this.add(Box.createVerticalStrut(10));
		

	}
	
	
    private void setupColorButtons() {
    	this.colorButtons.add(new ColorButton("RED", Color.RED, this.mainFrame));
    	this.colorButtons.add(new ColorButton("GREEN", Color.GREEN, this.mainFrame));
    	this.colorButtons.add(new ColorButton("DARK_GRAY", Color.DARK_GRAY, this.mainFrame));
    	this.colorButtons.add(new ColorButton("YELLOW", Color.YELLOW, this.mainFrame));
    	this.colorButtons.add(new ColorButton("BLACK", Color.BLACK, this.mainFrame));
    }

    public int getPenValue() {
    	return this.penSizeSlider.getValue();
    }
}
