package content;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.*;

public class guiHandler extends MouseAdapter{
	
		// private static final int MIN_PEN_SIZE = 1;
	    // private static final int MAX_PEN_SIZE = 30;
	    // private static final int STARTING_PEN_SIZE = 30;
	    
	
		private final Pen penManager;
	    private final JSlider penSizeSlider;
	    private JLabel penSizeLabel;
	    private final JLabel selectColorLabel;
		
	    
		private final DrawPanel pcenterPanel;
		

	    

	    private final MyFrame frame;
	    private final JPanel pEast;
	    private final Set<ColorButton> bColors;
	    private final JButton bDelete;
	    private final MyMouseListener myListener;
	    
	    public guiHandler() {
	    	
	    	
	    	this.penManager = new Pen();
	    	
	    	this.frame = new MyFrame("Java Paint",new BorderLayout());
	    	
	    	this.penSizeSlider = new JSlider(
	    			JSlider.HORIZONTAL, 
	    			penManager.getMinSize(), 
	    			penManager.getMaxSize(), 
	    			penManager.getSize()
	    			); 
	    	
	    	this.pcenterPanel = new DrawPanel();
	    	
	    	this.bColors = new HashSet<>();
	    	this.pEast = new JPanel();
	    	this.myListener = new MyMouseListener(this);
	    	
	    	this.bDelete = new JButton("Erase everything");
	    	this.bDelete.addActionListener(new ActionListener() {		
				public void actionPerformed(ActionEvent arg0) {
					guiHandler.this.getpCenterPanel().deleteEverything();	
					guiHandler.this.getpCenterPanel().repaint();
				}
			});
	    	
	    	this.selectColorLabel = new JLabel("Select color");	
	    	this.pEast.setLayout(new BoxLayout(this.pEast, BoxLayout.Y_AXIS) );
	    	this.pEast.setBackground(Color.WHITE);
	    	this.pEast.setBorder(new TitledBorder("Change settings here"));
	    	this.setPenSizeJSlider();
	    	this.getpCenterPanel().setBorder(new TitledBorder("Draw something here.."));
	    	this.setCenterPanelListeners();
	    	this.buildSettingsPanel();
			this.setFrameView();	
		}
	    
	    private void buildSettingsPanel() {
	    	this.addColorButtons();
	    	this.addVerticalSpacing(this.pEast, 25);
	    	this.pEast.add(this.penSizeLabel);
			this.addVerticalSpacing(this.pEast, 10);
			this.pEast.add(this.penSizeSlider);
			this.addVerticalSpacing(this.pEast, 10);
			this.pEast.add(this.selectColorLabel);
			this.addVerticalSpacing(this.pEast, 10);
			//Adding all buttons to pEast
			for(ColorButton b : this.bColors) {
				this.pEast.add(b);
				this.addVerticalSpacing(this.pEast, 5);
			}	
			
			this.addVerticalSpacing(this.pEast, 10);
			this.pEast.add(this.bDelete);
	    }
	    
	    private void addColorButtons() {
	    	this.bColors.add(new ColorButton("RED", Color.RED, this));
	    	this.bColors.add(new ColorButton("GREEN", Color.GREEN, this));
	    	this.bColors.add(new ColorButton("DARK_GRAY", Color.DARK_GRAY, this));
	    	this.bColors.add(new ColorButton("YELLOW", Color.YELLOW, this));
	    	this.bColors.add(new ColorButton("BLACK", Color.BLACK, this));
	    }
	    
	    private void addVerticalSpacing(JPanel target, int Yspacing) {
	    	target.add(Box.createVerticalStrut(Yspacing));
	    }
	    
	    private void setFrameView() {
	    	this.frame.getMainPanel().add(this.getpCenterPanel(),BorderLayout.CENTER);
	    	this.frame.getMainPanel().add(this.pEast,BorderLayout.EAST);
	    		
		}

		private void setCenterPanelListeners() { 	
	    	this.getpCenterPanel().addMouseListener(this.myListener);
	    	this.getpCenterPanel().addMouseMotionListener(this.myListener);
	    }
	    
	    private void setPenSizeJSlider() {
	    	this.penSizeSlider.setPaintTicks(true);
	    	this.penSizeLabel = new JLabel("Select pen size");
	    	this.penSizeSlider.setMajorTickSpacing(2);
	    }
	    
	    public DrawPanel getpCenterPanel() {
	    	return this.pcenterPanel;
	    }
	    
	    
	    // Pen Methods
	    
	    public void changeCurrentColor(Color c) {
	    	this.penManager.setColor(c);
	    }
	    
	    public Color getCurrentColor() {
	    	return this.penManager.getColor();
	    }

	    public int getPenSize() {
	    	return this.penSizeSlider.getValue();
	    }
	    
	    
	    
	    public void show(){
			this.frame.setVisible(true);
		}
	
}
