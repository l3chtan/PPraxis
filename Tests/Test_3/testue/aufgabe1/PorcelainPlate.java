public class PorcelainPlate extends Plate {

	protected boolean gold;
	protected int washingCycles;

	public PorcelainPlate(double diam, int depth, boolean gold){
		super(diam, depth);		
		this.gold = gold;
		this.washingCycles = 1000;
	}

	public String toString(){
		return String.format("ID: %d, Durchmesser: %.2f, Tiefe: %d, Spülgänge: %d, Goldrand: %b\n", serial, diam, depth, washingCycles, gold);
	}
}
