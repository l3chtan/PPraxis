
public class Train {

	private Locomotive lok; 
	static int first = 0;
	private Car current = null; 
	
	Train(Locomotive lok) {
		this.lok = lok; 		
	}
	
	void add(Car wagon)
	{
		if(first==0)
		{
			wagon.connectTo(this.lok);
			this.current = wagon; 
		}
		else
		{
			wagon.connectTo(this.current);
			this.current = wagon; 
		}
		first++;
	}
	
	boolean hasOpenDiningCar()
	{ 
		boolean ret = false;
		Car wagon = this.lok.next();
		if(wagon instanceof DiningCar)
		{
			if(((DiningCar) wagon).isOpen()==true)
			{
				ret = true;  
			}
		}
		while(wagon.next() != null)
		{
			wagon = wagon.next();
			if(wagon instanceof DiningCar)
			{
				if(((DiningCar) wagon).isOpen()==true)
				{
					ret = true;  
				}
			}	
		}	
		return ret; 
	}
	
	public String toString()
	{
		String ret = this.lok.toString() + "\n";
		if(this.lok.next()!=null)
		{
			Car wagon = this.lok.next(); 
			ret = ret + wagon.toString() + "\n"; 
			while(wagon.next()!=null)
			{
				wagon = wagon.next();
				ret = ret + wagon.toString() + "\n"; 
			}
		}
		
		if(this.hasOpenDiningCar()==true)
		{
			ret = ret + "Has open dining car"; 
		}
		return ret; 
	}
	
	
}
