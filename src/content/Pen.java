package content;

public class Pen {
	
	private static final int DEFAULT_SIZE = 15;
	
    private final int minSize = 1;
    private final int maxSize = 30;
    private int size;
    
    
    public Pen() {
    	this(Pen.DEFAULT_SIZE);
    }
    
    public Pen(final int penSize) {
    	this.size = penSize;
    }
    
    
    public void setSize(final int size) {
    	this.size = size;
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
}
