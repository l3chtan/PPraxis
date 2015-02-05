public class PassengerCar extends Car {

	protected int seat;

	public PassengerCar(double weight, double length, int seat){
		super(weight, length);
		this.seat = seat;
	}

	public String toString(){
		//return String.format("%d, %.2f, %.2f, %d\n", id, weight, length, seat);
		return (super.toString().replace("\n", "") + String.format(", %d\n",seat)); 
	}
}
