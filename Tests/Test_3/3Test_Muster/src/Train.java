public class Train {

	private Locomotive loc;
	private Car wagon, temp;

	public Train(Locomotive loc){
		this.loc = loc;	
		this.wagon = null;
	}

	public void add(Car car){

		if(this.loc.getNext() == null){
			car.connectTo(this.loc);
			this.wagon = car;
			this.temp = this.loc.getNext();
		} else {
			car.connectTo(this.wagon);
			this.wagon = car;
		}
	}

	public boolean hasOpenDiningCar(){

		if(this.temp instanceof DiningCar){
			return ((DiningCar)this.temp).isOpen();
		}
		if(this.temp.getNext() != null){
			this.temp = this.temp.getNext();	
			hasOpenDiningCar();
		}
		return false;
	}

	public String toString(){

		String out = "";

		this.temp = this.loc.getNext();
		out = loc.toString();

		if(this.temp != null){
			out += this.temp.toString();
			while(this.temp.getNext() != null){
				this.temp = this.temp.getNext();
				out += this.temp.toString();
			}
		}

		if(hasOpenDiningCar()){
			out += "Has open dining car";
		}

		return out;
	}
}
