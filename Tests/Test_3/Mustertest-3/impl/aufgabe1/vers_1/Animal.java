abstract class Animal {

	public boolean eatsMeat(){
		if(this instanceof Fleischfresser){
			return true;
		}
		return false;
	}

	abstract double dailyFoodQuantity();
}
