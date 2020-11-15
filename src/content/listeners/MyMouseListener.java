package content.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import content.uielements.MainFrame;

public class MyMouseListener implements MouseListener, MouseMotionListener{

	private final MainFrame gui;
	
	public MyMouseListener(MainFrame gui) {
		this.gui = gui;
	}
	
	public void repaint() {
		this.gui.getDrawPanel().repaint();
	}
	public void mouseDragged(MouseEvent e) {
    	this.gui.getDrawPanel().addPoint(e.getX(), e.getY());
    	this.repaint();
    }
	
	public void mouseReleased(MouseEvent e) {
    	this.gui.getDrawPanel().createLineObj();
    	this.repaint();
    }
	
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.repaint();
		
	}

	

}
