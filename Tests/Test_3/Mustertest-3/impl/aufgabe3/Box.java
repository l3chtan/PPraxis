import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
/*
 * 3. Aufgabe: Rekursion und Collections
 *
 * DER INHALT DIESER DATEI WIRD BEWERTET!
 */

import java.util.HashMap;

/**
 * Repräsentiert eine Box.
 * 
 * Eine Box hat eine durch einen String definierte Farbe und 
 * kann eine weitere Box beinhalten.
 */
public class Box {

	private String color;	
	private Box content;

	/**
	 * Initialisiert eine neue Box mit der angegebenen Farbe.
	 * 
	 * @param color Die Farbe der Box als String
	 */
	public Box(String color) {
		this.color = color;
	}

	/**
	 * Legt die übergebene Box in diese Box hinein. Falls sich
	 * bereits eine Box darin befindet, wird diese überschrieben.
	 * 
	 * @param box Die Box, die hineingelegt werden soll
	 */	 
	public void insert(Box box) {	
		this.content = box;
	}

	/**
	 * Gibt die häufigste Farbe unter den Boxen zurück. Hierbei
	 * werden alle in dieser Box enthaltenenen Boxen, sowie diese
	 * Box selbst berücksichtigt.
	 * Sie können davon ausgehen, dass es eine Farbe gibt, die am 
	 * häufigsten vorkommt.
	 * 
	 * @return Die häufigst vorkommende Farbe als String
	 */
	public String getMostFrequentColor() {


		Set<String> keys = countColors().keySet();
		Iterator<String> i = keys.iterator();
		int cnt1 = 0, cnt2 = 0;
		String tmp1 = "", tmp2 = "";

		while(i.hasNext()){
			tmp1 = i.next();
			cnt1 = countColors().get(tmp1);
			if(cnt1>cnt2){
				cnt2 = cnt1;
				tmp2 = tmp1;
			}
		}

		return tmp2;	

	}

	/**
	 * Gibt eine HashMap zurück, in der zu jeder vorkommende Farbe, 
	 * die Häufigkeit steht. Die Methode berücksichtigt alle enthaltenen
	 * Boxen, sowie diese Box. Die enthaltenen Boxen sollen rekursiv 
	 * durchlaufen werden.
	 * 
	 * @return Eine HashMap mit den Vorkommen der einzelnen Farben
	 */
	public HashMap<String, Integer> countColors() {

		HashMap<String, Integer> cols = new HashMap<String, Integer>();

		//System.out.printf("Ich wurde aufgerufen!\n");

		if(this.content == null){
			cols.put(color, 1);
		} else if(!this.content.countColors().isEmpty()){
			cols.putAll(this.content.countColors());

			if(this.content.countColors().containsKey(color)){
				int c = this.content.countColors().get(color);
				cols.put(color, c+1);
			} else {
				cols.put(color, 1);
			}
		}

		return cols;

	}

}
