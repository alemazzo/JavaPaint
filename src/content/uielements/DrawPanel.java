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
import java.util.List;

// Specializzazione ad-hoc per un JPanel
public class DrawPanel extends JPanel {

	private static final long serialVersionUID = 7114066347061701832L;
	
	private MainFrame mainFrame;
	
	private Set<List<Pair<Point, Pair<Color, Integer>>>> lines; 
	private List<Pair<Point, Pair<Color, Integer>>> circles;
	
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
		
		this.circles = new ArrayList<>();
		this.lines = new HashSet<>(); 
		this.lines.add(this.circles);
	}
	

	// override del metodo di disegno  
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (List<Pair<Point, Pair<Color, Integer>>> e : this.lines) {
			Point last = null;
			for(Pair<Point, Pair<Color, Integer>> c : e) {
				g.setColor(c.second.getFirst());
				g.fillOval(c.first.x, c.first.y, c.second.getSecond(), c.second.getSecond());
				if (last != null) {
					g.drawLine(
							(int) last.getX() + (AppState.pen.getSize()/2), 
							(int) last.getY() + (AppState.pen.getSize()/2), 
							c.first.x + (AppState.pen.getSize()/2), 
							c.first.y + (AppState.pen.getSize()/2)
							);
				}
				last = new Point(c.first.x, c.first.y);
			}
		}
	}
	
	public void deleteEverything() {
		this.circles = new ArrayList<>();
		this.lines = new HashSet<>();
		this.lines.add(circles);
	}
	
	
	public void createLineObj() {
		if (this.circles.size() != 0) {
			this.lines.add(this.circles);
			this.circles = new ArrayList<>();
		}
	}
	
	public void addPoint(int x, int y){
		Pair<Point, Pair<Color, Integer>> point = new Pair<>(
				new Point(x-(AppState.pen.getSize()/2), y-(AppState.pen.getSize()/2)), 
				new Pair<Color, Integer>(AppState.pen.getColor(), AppState.pen.getSize())
				);
		this.circles.add(point);
	}
	
}
