public class Pflanzenfresser extends Tiere{

	private boolean eatsMeat;

	public Pflanzenfresser(boolean eatsMeat){
		this.eatsMeat = eatsMeat;
	}

	public boolean eatsMeat(){
		return this.eatsMeat;
	}

}
