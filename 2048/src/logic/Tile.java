package logic;

public class Tile implements Cloneable {
	
	private int number;
	private boolean empty;
	
	public Tile() {
		empty = true;
	}
	
	public int getNumber() {
		return number;
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public void merge(Tile t) {
		if (this.isEmpty() || t.isEmpty()) {
			// TODO throws exception
		}
		else if (this.getNumber() != t.getNumber()) {
			// TODO throws exception
		}
		this.setNumber(this.getNumber()+t.getNumber());
		t.setEmpty();
	}
	
	public void slide(Tile t) {
		if (!this.isEmpty() && t.isEmpty()) {
			t.setEmpty();
			t.setNumber(this.getNumber());
			this.setEmpty();
		}
		else {
			// TODO throws exception
		}
	}
	
	public void activate(int number) {
		this.number = number;
		this.setEmpty();
	}
	
	public boolean couldSum(Tile t) {
		if (this.getNumber() == t.getNumber() && !this.isEmpty() && !t.isEmpty())
			return true;
		else
			return false;
	}
	
	public Object clone() throws CloneNotSupportedException {
		Tile cloned = new Tile();
		
		if (!this.isEmpty())
			cloned.setEmpty();
		cloned.setNumber(this.number);
		return cloned;
	}
	
	private void setNumber (int number) {
		this.number = number;
	}
	
	private void setEmpty() {
		if (empty) 
			empty = false;
		else
			empty = true;
	}
}