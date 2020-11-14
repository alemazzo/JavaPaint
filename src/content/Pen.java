package content;

import java.awt.Color;

public class Pen {
	
	private static final int DEFAULT_SIZE = 15;
	private static final Color DEFAULT_COLOR = Color.BLACK;
	
	private Color color;
    private final int minSize = 1;
    private final int maxSize = 30;
    private int size;
    
    
    public Pen() {
    	this(Pen.DEFAULT_SIZE, Pen.DEFAULT_COLOR);
    }
    
    public Pen(final int penSize) {
    	this(penSize, Pen.DEFAULT_COLOR);
    }
    
    public Pen(final Color penColor) {
    	this(Pen.DEFAULT_SIZE, penColor);
    }
    
    public Pen(final int penSize, final Color penColor) {
    	this.size = penSize;
    	this.color = penColor;
    }
    
    
    public void setSize(final int size) {
    	this.size = size;
    }
    
    public void setColor(final Color color) {
    	this.color = color;
    }
    
    
    
    public int getSize() {
    	return this.size;
    }
    
    public int getMinSize() {
    	return this.minSize;
    }
    
    public int getMaxSize() {
    	return this.maxSize;
    }
    
    public Color getColor() { 
    	return this.color;
    }
}

