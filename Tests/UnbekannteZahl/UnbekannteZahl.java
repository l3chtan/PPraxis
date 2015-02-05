import java.util.Random;

public class UnbekannteZahl {
	
	// die Zahl ist nur innerhalb der Klasse bekannt
	private int zahl;
	
	// Initialisierung mit Zufallszahl zwischen 0 und (grenze - 1)
	// Voraussetzung: grenze > 0
	public UnbekannteZahl (int grenze) {
		zahl = (new Random()).nextInt() % grenze;
		if (zahl < 0) {
			zahl = zahl + grenze;
		}
	}
	
	// Ergebnis von "gleich(n)" ist true wenn zahl gleich n ist
	public boolean gleich (int vergleichszahl) {
		return (zahl == vergleichszahl);
	}
	
	// Ergebnis von "kleiner(n)" ist true wenn zahl kleiner n ist
	public boolean kleiner (int vergleichszahl) {
		return (zahl < vergleichszahl);
	}
}
