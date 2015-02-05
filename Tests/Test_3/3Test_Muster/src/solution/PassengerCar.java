
public class PassengerCar extends Car{
	private int plaetze; 
	
	PassengerCar(double gewicht, double laenge, int plaetze)
	{
		super(gewicht, laenge); 
		this.plaetze = plaetze; 		
	}
	
	public String toString()
	{
		String str =  "serial: " + super.serial + " gewicht: " + super.gewicht + " laenge: " + super.laenge + " plaetze: " + this.plaetze; 
		return str;
	}
	
}

