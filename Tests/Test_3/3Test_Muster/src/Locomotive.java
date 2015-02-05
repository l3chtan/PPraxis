public class Locomotive extends Car {
	
	private int kW;

	public Locomotive(double weight, double length, int kW){
		super(weight, length);
		this.kW = kW;	
	}
	
	public String toString(){
		return String.format("%d, %.2f, %.2f, %d\n", this.id, this.weight, this.length, this.kW);	
	}

}
