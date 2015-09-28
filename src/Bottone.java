import javax.swing.JButton;

    public class Bottone extends JButton {
    	
    	private int x;
    	private int y;
    	
    	public Bottone(int x, int y) {
    		super();
    		this.x = x;
    		this.y = y;
    	}
    
    	public int getbX() {
    		
    		return x;
    	}
    	
    	public int getbY() {
    		
    		return y;
    	}
    
    }