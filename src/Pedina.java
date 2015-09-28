
public class Pedina {

	private int x;
	private int y;
	private Colore colore;
	private Pezzo pedina;

	public Pedina() { 
	}
	
	public Pedina(int x, int y, Colore colore, Pezzo pedina){
		this.x = x;
		this.y = y;
		this.colore = colore;
		this.pedina = pedina;
	}
	
	public Colore getColore() {
		return colore;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Pezzo getType() {
		return pedina;
	}
	
	public void setTypePedina(Pezzo pezzo) {
		this.pedina = pezzo;
	}
	
	public void setCoordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}