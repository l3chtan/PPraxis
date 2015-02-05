/*
 * 1. Aufgabe: Typbeziehungen
 * 
 * Der Inhalt dieser Datei wird nicht bewertet.
 */
public class Zoo {
	
	public static void main(String[] args) {
		
		Tiger a = new Tiger();
		if(a.eatsMeat()){
			System.out.printf("a isst Fleisch.\n");
		} else {
			System.out.printf("a isst kein Fleisch\n");
		}

		System.out.printf("a isst täglich %.2fkg Fleisch.\n", a.dailyFoodQuantity());
	}
	
}
