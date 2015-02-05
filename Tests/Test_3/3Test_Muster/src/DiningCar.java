public class DiningCar extends PassengerCar {

	private boolean open;

	public DiningCar(double weight, double length, int seat, boolean open){
		super(weight, length, seat);
		this.open = open;
	}

	public boolean isOpen(){
		return this.open;
	}

	public String toString(){
		return (super.toString().replace("\n", "") + String.format(", %b\n",open)); 
	}


}
