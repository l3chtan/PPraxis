import java.util.Scanner;

public class Zahlenraten {

	// Startpunkt des Programms
	// args ist notwendig, wird aber nicht verwendet
	public static void main(String[] args) {

		// die zu erratende Zahl steht in zuErraten
		UnbekannteZahl zuErraten = new UnbekannteZahl(100);
		
		// von sc wird die Eingabe in das Programm eingelesen
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Errate Zahl zwischen 0 und 99:");
		
		while (sc.hasNext()) {
			if (sc.hasNextInt()) {
				// versuch enthält die Zahl, die wir probieren
				int versuch = sc.nextInt();
				
				if (versuch < 0 || versuch > 99) {
					System.out.println("Nur Zahlen von 0 bis 99!");
				}
				else if (zuErraten.gleich(versuch)) {
					System.out.println("Gratulation! Zahl erraten!");
					return;
				}
				else if (zuErraten.kleiner(versuch)) {
					System.out.println("Gesuchte Zahl ist kleiner.");
				}
				else {
					System.out.println("Gesuchte Zahl ist größer.");
				}
			}
			else {
				sc.next();
				System.out.println("Das ist keine erlaubte Zahl.");
			}
			
			System.out.println("Neuer Versuch (Ende mit ^D):");
			
		} // hier endet die Schleife, wenn es keine Eingabe mehr gibt
		
		// Zahl nicht gefunden
		System.out.println("Zahl leider nicht erraten :-(");
	}

}
