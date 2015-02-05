public class Plate {

	protected double diam;
	protected int depth;
	protected final int serial;
	protected Plate next;
	static int count;

	public Plate(double diam, int depth){
		this.diam = diam;
		this.depth = depth;
		serial = count + 1;
		count++;
		next = null;
	}

	public void putOn(Plate plate){
		plate.next = this;				
	}

	public Plate next(){
		return this.next;
	}

	public String toString(){
		return String.format("ID: %d, Durchmesser: %.2f, Tiefe: %d\n",serial, diam, depth);
	}

	
}
