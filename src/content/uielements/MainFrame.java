package content.uielements;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.*;

import content.AppState;
import content.structures.*;
import content.utils.*;
import jdk.nashorn.api.tree.NewTree;

public class MainFrame extends MouseAdapter{
		
		// Main Frame
    	private final MyFrame frame;
	
	    // Main Panels
    	private final ToolsPanel toolsPanel;
		private final DrawPanel drawPanel;
	    private final SettingsPanel settingsPanel;

		

	    public MainFrame() {
	    	
	    	this.frame = new MyFrame("Java Paint", new BorderLayout());
	    	
	    	this.toolsPanel = new ToolsPanel(this, "Tools");
	    	this.drawPanel = new DrawPanel(this, "Drawing Area");
	    	this.settingsPanel = new SettingsPanel(this, "Settings");    		    	
	    	    	
			this.setFrameView();	
		}

	    
	    private void setFrameView() {
	    	this.frame.getMainPanel().add(this.toolsPanel, BorderLayout.NORTH);
	    	this.frame.getMainPanel().add(this.drawPanel, BorderLayout.CENTER);
	    	this.frame.getMainPanel().add(this.settingsPanel, BorderLayout.EAST);
	    		
		}
	    
	    public DrawPanel getDrawPanel() {
	    	return this.drawPanel;
	    }

	    // Pen Methods
	    
	    public void changeCurrentColor(Color c) {
	    	AppState.pen.setColor(c);
	    }
	    
	    public Color getCurrentColor() {
	    	return AppState.pen.getColor();
	    }

	    
	    public int getPenSize() {
	    	return AppState.pen.getSize();
	    }
	    
	    
	    
	    public void show(){
			this.frame.setVisible(true);
		}
	
}
