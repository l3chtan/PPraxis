
class DiningCar extends PassengerCar{

	private boolean open; 
	
	DiningCar(double gewicht, double laenge, int plaetze, boolean open)
	{
		super(gewicht, laenge, plaetze);
		this.open = open; 
	}
	
	boolean isOpen()
	{
		if(this.open == true)
			return true; 
		return false; 
	}
	
	
	public String toString()
	{
		String str1 = super.toString();
		String strOpen; 
		if(open==false)
		{
			strOpen = "nein"; 
		}
		else
		{
			strOpen = "ja"; 
		}
		String str =  str1 + " geoeffnet: " + strOpen; 
		return str;
	}

}
