public class Car {

	static int count;
	protected final int id;
	protected double weight, length; 
	protected Car next;

	public Car(double weight, double length){
		this.id = count+1;
		this.weight = weight;
		this.length = length;
		this.next = null;
		count++;
	}

	public double getWeight(){
		return this.weight;
	}

	public double getLength(){
		return this.length;
	}

	public String toString(){
		return String.format("%d, %.2f, %.2f\n",id, weight, length);
	}

	public void connectTo(Car car){
		car.next = this;	
	}
	
	public Car getNext(){
		return this.next;
	}
}
