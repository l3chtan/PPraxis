public class Knife {

	private int length;
	private int wCycles;

	public Knife(int length){
		this.length = length;
			wCycles = 700;
	}

	public String toString(){
		return String.format("Länge: %d, Spülgänge: %d",length, wCycles);
	}
}
