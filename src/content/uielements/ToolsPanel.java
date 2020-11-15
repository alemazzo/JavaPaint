package content.uielements;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

public class ToolsPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -809738724939015369L;
	
    // A reference to the Main Frame
    private final MainFrame mainFrame;
	
    private JButton penButton;
    private JButton selectButton;
    private JButton eraseButton;
	
	
	public ToolsPanel(MainFrame main, String title) {
		this.mainFrame = main;
		
    	this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS) );
    	this.setBackground(Color.WHITE);
    	this.setBorder(new TitledBorder(title));

    	this.build();  	
    	
	}
	
	public void build() {
		
		this.penButton = new JButton("Pen");
		this.selectButton = new JButton("Select");
		this.eraseButton = new JButton("Erase");
		
		this.add(this.selectButton);
		this.add(Box.createHorizontalStrut(10));
		
		this.add(this.eraseButton);
		this.add(Box.createHorizontalStrut(10));
		
		this.add(this.penButton);
		this.add(Box.createHorizontalStrut(10));

	}

	
}
