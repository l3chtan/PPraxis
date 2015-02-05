public class Tiere {

	private double food;
	private boolean eatsMeat;
	private String name;

	public Tiere(String name, double food, boolean eatsMeat){
		this.food = food;
		this.eatsMeat = eatsMeat;
	}

	public boolean eatsMeat(){
		return this.eatsMeat;
	}

	public double dailyFoodQuantity(){
		return this.food;		
	}

	public String name(){
		return name;
	}
}
