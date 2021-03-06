package content.uielements;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import content.AppState;

public class ColorButton extends JButton {
	private static final long serialVersionUID = 1L;
	private final Color c;
	private boolean isColored;
	private int clickCount;
	
	public ColorButton(String name, Color c, MainFrame m) {
		super(name);
		this.c = c;
		this.isColored = false;
		this.clickCount = 0;
		this.setBackground(Color.WHITE);
		
		/*
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				if(getClickCount() < 1) {
					AppState.pen.setColor(getButtonColor());
					AppState.pen.setColor(m.getCurrentColor());
					ColorButton.this.increaseClickCount();
					ColorButton.this.setBackground(ColorButton.this.getButtonColor());
					ColorButton.this.colored(true);
				}else {
					ColorButton.this.resetClickCount();
					ColorButton.this.colored(false);
					m.changeCurrentColor(Color.BLACK);
					AppState.pen.setColor(m.getCurrentColor());
				}
				
			}	
		});	
		
		this.addMouseListener(new MouseAdapter() {
    		public void mouseEntered(MouseEvent e) {
    			ColorButton.this.setBackground(ColorButton.this.getButtonColor());
    		}
    		public void mouseExited(MouseEvent e) {
    			if(!ColorButton.this.amIcolored()) {
    				ColorButton.this.setBackground(Color.LIGHT_GRAY); 
    			}
				  			
    		}
    	});
		*/
	}
	
	public void increaseClickCount() {
		this.clickCount++;
	}
	
	public int getClickCount() {
		return this.clickCount;
	}
	
	public void resetClickCount() {
		this.clickCount = 0;
	}
	
	public void colored(boolean isColored) {
		this.isColored = isColored;
	}
	
	public boolean amIcolored() {
		return this.isColored;
	}
	
	public Color getButtonColor() {
		return this.c;
	}
	
	public void setClicked() {
		ColorButton.this.setBackground(Color.LIGHT_GRAY);
	}
	
	public void setUnclicked() {
		ColorButton.this.setBackground(Color.WHITE);
	}
		   
}
