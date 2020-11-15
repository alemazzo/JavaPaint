package content.uielements;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import content.AppState;
import content.structures.Pair;

import java.util.*;

// Specializzazione ad-hoc per un JPanel
public class DrawPanel extends JPanel {

	private static final long serialVersionUID = 7114066347061701832L;
	
	private MainFrame mainFrame;
	
	private Set<Map<Point, Pair<Color, Integer>>> lines; 
	private Map<Point, Pair<Color, Integer>> circles;
	
	public DrawPanel(MainFrame mainFrame, String title) {
		
		this.setBorder(new TitledBorder(title));
		
		this.mainFrame = mainFrame;
		

		this.addMouseMotionListener(new MouseMotionListener() {
			
			public void repaint() {
				DrawPanel.this.mainFrame.getDrawPanel().repaint();
			}
			
			@Override
			public void mouseMoved(MouseEvent e) {
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				DrawPanel.this.mainFrame.getDrawPanel().addPoint(e.getX(), e.getY());
		    	this.repaint();
				
			}
		});
		
		this.circles = new HashMap<>();
		this.lines = new HashSet<>(); 
		this.lines.add(this.circles);
	}
	

	// override del metodo di disegno  
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Map<Point, Pair<Color, Integer>> e : this.lines) {
			for(Map.Entry<Point, Pair<Color, Integer>> c : e.entrySet()) {
				g.setColor(c.getValue().first);
				g.fillOval(c.getKey().x, c.getKey().y, c.getValue().second, c.getValue().second);
			}
		}
	}
	
	public void deleteEverything() {
		this.lines = new HashSet<>();
	}
	
	
	public void createLineObj() {
		if (this.circles.size() != 0) {
			this.lines.add(this.circles);
			this.circles = new HashMap<>();
		}
	}
	
	public void addPoint(int x, int y){
		this.circles.put(new Point(x-(AppState.pen.getSize()/2), y-(AppState.pen.getSize())/2), new Pair<Color, Integer>(AppState.pen.getColor(), AppState.pen.getSize()));
	}
	
}
