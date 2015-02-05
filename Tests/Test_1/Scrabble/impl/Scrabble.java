import java.util.Scanner;
import java.util.Arrays;

public class Scrabble {
	
	/**
	* main-Methode: liest von der Standardeingabe ein und arbeitet die
	* einegegebenen Befehle ab. Erzeugt entsprechende Ausgaben.
	*/
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		String eingabe = sc.next();
			
		//macht aus einem String ein char-Array
		char[] charSet = eingabe.toCharArray(); 
		
		while(sc.hasNext()){
			
			String command = sc.next();
			
			 
			if(command.equals("occurrences")) {

				String a = sc.next();
				char c = a.charAt(0);
				
				System.out.println(occurrences(charSet, c));
				//System.out.println(occurrences(eingabe, c));
			}
			if(command.equals("distinct")) {
				System.out.println(distinct(sc.next()));
			}
			if(command.equals("buildword")) {
				if(buildWord(sc.next(), charSet) == true){
					System.out.println("true");
				} else {
					System.out.println("false");
				}
			}
			if(command.equals("moveleft")) {
				String a = sc.next();
				char c = a.charAt(0);
				moveLeft(charSet, c);
			}
			if(command.equals("print")) {
				System.out.println(Arrays.toString(charSet));
			}
			
			
		}
	}
	
	/**
	* bewegt alle Vorkommnisse des Zeichens c im Array charSet ganz nach 
	* links. Die Reihenfolge aller anderen Zeichen im Array ist danach 
	* beliebig.
	* @param charSet Das Array mit der Zeichenmenge
	* @param c Alle Vorkommnisse dieses Zeichens sollen im Array ganz nach 
	* links bewegt werden.
	*/
	public static void moveLeft(char[] charSet, char c) {
		
		int count = occurrences(charSet, c);
		char[] temp = new char[count];
		for(int i=0;i<count;i++){
			temp[i] = charSet[i];
			charSet[i] = c;
		}
		int tmp_c = 0;
		for(int j=count;j<charSet.length;j++){
			
			if(charSet[j] == c && tmp_c <= count){
				charSet[j] = temp[tmp_c];
				tmp_c++;
			}
		}
		
	}
	
	/**
	* liefert die Häufigkeit des angegebenen Zeichens c in der 
	* Zeichenfolge charSet zurück
	* @param charSet Das Array mit der Zeichenmenge
	* @param c Alle Vorkommnisse dieses Zeichens werden gezählt
	* @return Die Anzahl der Vorkommnisse
	*/
	public static int occurrences(char[] charSet, char c) {
		int ccount = 0;
		
		for(int i=0;i<charSet.length;i++){
			if(charSet[i] == c){
				ccount++;
			}
		}
		return ccount;
		
	}
	
	
	/**
	* liefert die Häufigkeit des angegebenen Zeichens c im 
	* String word
	* @param word Eine Zeichenkette in der die Anzahl des angegebenen 
	* Zeichens bestimmt wird
	* @param c Alle Vorkommnisse dieses Zeichens werden gezählt
	* @return Die Anzahl der Vorkommnisse
	*/
	public static int occurrences(String word, char c) {
	
		char[] word = word.toCharArray();		
		return occurrences(word, c);
		
	}
	
	/**
	* liefert einen String, der alle Zeichen enthält, die auch in word 
	* vorkommen, jedoch keine Zeichen mehrfach enthält. Die Reihenfolge der 
	* Zeichen ist beliebig.
	* @param word Der Eingabestring
	* @return Ein String in dem die Zeichen des Eingabestrings einmalig
	* vorkommen.
	*/
	public static String distinct(String word) {
		
		String word_dist = "";
		word_dist += word.charAt(0);
		
		for(int m=0;m<word.length();m++){
			String a = "";
			a += word.charAt(m);
			if(!word_dist.contains(a)){
				word_dist += word.charAt(m);
			}
		}
		return word_dist;
		
	}
	
	/**
	* liefert einen boolean Wert der angibt, ob das als Parameter 
	* angegebene Wort word aus den im Array from gespeicherten Zeichen
	* gebildet werden kann (true) oder nicht (false).
	* @param word Das zu bildende Wort
	* @param from Aus den Zeichen dieses Arrays soll das Wort gebildet 
	* werden
	* @return true wenn das Wort gebildet werden kann, sonst false
	*/
	public static boolean buildWord(String word, char[] from) {
		
		boolean flag = true;
		String from1 = "";
		from1 = Arrays.toString(from);
		
			for(int o=0;o<word.length();o++){

				if(from1.indexOf(word.charAt(o)) == -1){
					flag = false;
					break;
					
				}
			}
		return flag;
	}
	
}
