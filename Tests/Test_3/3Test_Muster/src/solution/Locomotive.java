
class Locomotive extends Car 
{
	private int leistung; 
	
	Locomotive(double gewicht, double laenge, int leistung) 
	{		
		super(gewicht, laenge);
		this.leistung = leistung; 		
	}
	
	public String toString()
	{
		String str =  "serial: " + super.serial + " gewicht: " + super.gewicht + " laenge: " + super.laenge + " leistung: " + this.leistung; 
		return str;
	}
}
