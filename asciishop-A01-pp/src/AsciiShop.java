import java.util.Scanner;

public class AsciiShop{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int height = 0;
		int width = 0;
		String line = "";
		boolean okay = true;
		
		if(sc.hasNext()){			//Die if-Abfrage überprüft ob überhaupt eine Zeile vorhanden ist die eingelesen werden kann.
			line = sc.next();		//Wenn eine vorhanden ist, wird die erste Zeile gleich eingelsen, die Länge der Zeile gespeichert und für alle weiteren Zeilen als referenz verwendet
			width = line.length();		//Zusätzlich wird die Höhe des Bildes um eins erhöht.
			height++;			//Ist die Quelldatei leer, wird der Fehler "INPUT MISMATHCH" ausgegeben.
		} else {
			okay = false;
		}
		
		while(sc.hasNext() && okay){		//Die While-Schleife durchläuft das Bild Zeile für Zeile (unter der Annahme, dass keine Leerzeichen im Bild sind) bis zur letzten Zeile
							
			line = sc.next();		//Jede neu eingelesene Zeile wird im String "line" gespeichert, und die vorherige Zeile überschrieben
			
			if(line.length() != width){	//Die If-Abfrage vergleicht die Breite des Bildes (also die Länge der ersten Zeile) mit der Länge jeder neu eingelesenen Zeile. 
				okay = false;		//Sind die Werte verschieden, wird wieder der Fehler "INPUT MISMATCH" ausgegeben.
			}
			
			height++;			//Die Höhe des Bildes wird mit jeder neuen Zeile aktualisiert.
		}
		if(okay){						//Ist beim Einlesen des Bildes kein Fehler aufgetreten werden die Breite und die Höhe des Bildes ausgegeben, andernfalls wird "INPUT MISMATCH" ausgegeben.
			System.out.println(width + " " + height);
		} else {
			System.out.println("INPUT MISMATCH");
		}
	}
}