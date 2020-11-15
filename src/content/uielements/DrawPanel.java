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
	
	private List<Pair<Point, Pair<Color, Integer>>> selectedCircles;
	private Pair<Point, Pair<Color, Integer>> selectedPoint;
	private Color oldColor;
	
	private Set<List<Pair<Point, Pair<Color, Integer>>>> lines; 
	private List<Pair<Point, Pair<Color, Integer>>> circles;
	
	public DrawPanel(MainFrame mainFrame, String title) {
		
		this.setBorder(new TitledBorder(title));
		
		this.mainFrame = mainFrame;
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (DrawPanel.this.selectedCircles != null) {
					DrawPanel.this.translateSelectedCircle(e.getX(), e.getY());
					for (Pair<Point, Pair<Color, Integer>> point : DrawPanel.this.selectedCircles) {
						point.second.first = oldColor;
					}
					DrawPanel.this.repaint();
					
					DrawPanel.this.selectedCircles = null;
					DrawPanel.this.selectedPoint = null;
					DrawPanel.this.oldColor = null;
					DrawPanel.this.repaint();
				}{
					DrawPanel.this.mainFrame.getDrawPanel().createLineObj();
					DrawPanel.this.mainFrame.getDrawPanel().repaint();
				}

				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if (DrawPanel.this.selectedCircles == null) {
					DrawPanel.this.selectCircleByClick(e.getX(), e.getY());	
					for (Pair<Point, Pair<Color, Integer>> point : DrawPanel.this.selectedCircles) {
						oldColor = point.second.first;
						point.second.first = Color.LIGHT_GRAY;
					}
					DrawPanel.this.repaint();
				}
				


				
			}
		});

		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if (DrawPanel.this.selectedCircles != null) {
					DrawPanel.this.translateSelectedCircle(e.getX(), e.getY());
					DrawPanel.this.repaint();
				}else {
					DrawPanel.this.mainFrame.getDrawPanel().addPoint(e.getX(), e.getY());
					DrawPanel.this.mainFrame.getDrawPanel().repaint();
				}

				
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
				if (last != null) {
					Graphics2D g2d = (Graphics2D) g;
					g2d.setColor(c.second.getFirst());
					g2d.setStroke(new BasicStroke(c.second.getSecond(), BasicStroke.CAP_ROUND, BasicStroke.CAP_SQUARE));
					g2d.drawLine(
							(int) last.getX() + (c.second.getSecond() / 2), 
							(int) last.getY() + (c.second.getSecond() / 2), 
							c.first.x + (c.second.getSecond() / 2), 
							c.first.y + (c.second.getSecond() / 2)
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
			this.circles = new ArrayList<>();
			this.lines.add(circles);
		}
	}
	
	public void addPoint(int x, int y){
		Pair<Point, Pair<Color, Integer>> point = new Pair<>(
				new Point(x-(AppState.pen.getSize()/2), y-(AppState.pen.getSize()/2)), 
				new Pair<Color, Integer>(AppState.pen.getColor(), AppState.pen.getSize())
				);
		this.circles.add(point);
	}
	
	public void selectCircleByClick(final int x, final int y){
		for (List<Pair<Point, Pair<Color, Integer>>> circle : this.lines) {
			for (Pair<Point, Pair<Color, Integer>> point : circle) {
				if (
						Math.sqrt((point.first.x - x) * (point.first.x - x)) <= point.second.second && 
						Math.sqrt((point.first.y - y) * (point.first.y - y)) <= point.second.second
					) {
					this.selectedCircles = circle;
					this.selectedPoint = point;
					return;
				}
			}
		}
		return;
	}
	
	public void translateSelectedCircle(int x, int y) {
		int diffX = x - (int) this.selectedPoint.first.getX();
		int diffY = y - (int) this.selectedPoint.first.getY();
		
		for (Pair<Point, Pair<Color, Integer>> pair : selectedCircles) {
			pair.first.x += diffX;
			pair.first.y += diffY;
		}		
		
		
	}
	
}
