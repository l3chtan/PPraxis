import java.util.ArrayList;

/**
 * Diese Klasse repräsentiert eine Melodie, die aus mehreren Noten besteht. Die
 * Noten werden in geeigneter Form gespeichert. Verschiedene Methoden
 * ermöglichen das Hinzufügen von Noten, das Kopieren von Notenfolgen und das
 * Transponieren der Melodie. Diese Klasse liest weder direkt von System.in ein,
 * noch gibt sie direkt auf System.out aus.
 */
public class Melody {

	private ArrayList<Note> noten;
	private int bpm;

	/**
	 * erzeugt eine neue Instanz von Melody und speichert das übergebene Tempo
	 * (bpm, Schläge pro Minute).
	 * 
	 * @param bpm
	 *            Das Tempo in Schlägen pro Minute
	 */
	public Melody(int bpm) {
		
		this.bpm = bpm;	
		noten = new ArrayList<Note>();
	}

	/**
	 * fügt am Ende der Melodie die übergebene Note hinzu.
	 * 
	 * @param note
	 *            Die hinzuzufügende Note
	 */
	public void addNote(Note note) {
		
		noten.add(note);	
	}

	/**
	 * kopiert eine Folge von Noten und gibt diese als neue Melodie (Melody)
	 * zurück. Die neue Melodie hat dabei das gleiche Tempo, die kopierten Noten
	 * sollen echte Kopien der ursprünglichen Noten sein. Die neue Melodie
	 * beinhaltet die Noten zwischen inklusive beginIndex und exklusive
	 * endIndex, hat also die Länge endIndex - beginIndex. Besteht die
	 * gespeicherte Melodie beispielsweise aus den Tönen do - re - mi - fa -
	 * sol, so lautet die neue Melodie bei Aufruf der Methode mit den Parametern
	 * beginIndex=1 und endIndex=4 re - mi - fa und hat die Länge 3.
	 * 
	 * @param beginIndex
	 *            Der erste Index der ersten enthaltenen Note
	 * @param endIndex
	 *            Der Index der ersten nicht mehr enthaltenen Note
	 * @return Eine neue Melody aus dem spezifizierten Notenbereich
	 */
	public Melody copy(int beginIndex, int endIndex) {
		
		Melody newMelody = new Melody(bpm);
		ArrayList<Note> neu = new ArrayList<Note>();

		for(Note e:noten){
			neu.add(new Note(e));
		}
		for(int i= beginIndex;i<endIndex;i++){
			newMelody.addNote(neu.get(i));	
		}
	return newMelody;
		
	}

	/**
	 * verhält sich wie public Melody copy(int beginIndex, int endIndex),
	 * erwartet jedoch nur den Parameter beginIndex und gibt eine neue Melodie
	 * bestehend aus den Noten von inklusive beginIndex bis zum Ende der Melodie
	 * zurück.
	 * 
	 * @param beginIndex
	 *            Der erste Index der ersten enthaltenen Note
	 * @return Eine neue Melody aus dem spezifizierten Notenbereich
	 */
	public Melody copy(int beginIndex) {
		
		return copy(beginIndex, noten.size());
	}

	/**
	 * setzt das Tempo der Melodie auf den übergebenen Wert (bpm, Schläge pro
	 * Minute).
	 * 
	 * @param bpm
	 *            Das neue Tempo in Schlägen pro Minuten
	 */
	public void setBPM(int bpm) {
		
		this.bpm = bpm;	
	}

	/**
	 * transponiert alle Noten der Melodie um den gleichen Wert nach oben oder
	 * nach unten. Besteht die Melodie beispielsweise aus den Noten do - mi -
	 * re, so lauten diese nach Aufruf der Methode mit steps=3 fa - la - sol.
	 * Dabei liegt ein zyklischer Abschluss vor: Die sieben Noten lauten do - re
	 * - mi - fa - sol - la - si. Auf die letzte Note si folgt wieder do.
	 * 
	 * @param steps
	 *            Um wieviele Schritte transponiert werden soll
	 */
	public void transpose(int steps) {
		
		for(Note e:noten){
			e.transpose(steps);
		}	
	}

	/**
	 * gibt die Töne der Melodie in der Form Notenname gefolgt von einem
	 * Leerzeichen und der Notenlänge (in Schläge pro Minute) zurück. Zwischen
	 * zwei Noten steht jeweils ein Leerzeichen, alle Noten stehen in der
	 * gleichen Zeile. In einer neuen Zeile wird die Dauer der Melodie in
	 * Sekunden ausgegeben. Ist die gespeicherte Melodie beispielsweise do 1 re
	 * 1 mi 2 fa 4, ist die Gesamtdauer 8 Schläge. Ist das Tempo der Melodie 80
	 * Schläge pro Minute, so beträgt die Länge 6 Sekunden.
	 * 
	 * do 1 re 1 mi 2 fa 4
	 * 6.0 seconds
	 * 
	 * @return Eine lesbare Repräsentation dieser Melody
	 */
	public String toString() {
		//Gesamtdauer in Schlägen mal 60 durch 	bpm	
		String out = "";
		double schlaege = 0.0;

		for(Note e: noten){
			out += e.toString() + " ";	
			schlaege += e.getBeats();
		}
		out += String.format("%n%.1f seconds", (schlaege*60/bpm));
		return out;
		
	}

}
