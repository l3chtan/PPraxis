import java.util.Arrays;

public class MedianOperation implements Operation{

	private int[] median;
	private AsciiImage img;
	/**
	 * Konstruktor.
	 * Initialisiert ein Integer-Array der Größe neun.*/
	public MedianOperation(){
		median = new int[9];
	}
	/**
	 * Glättet das Bild.
	 * Eine Kopie des übergebenen AsciiImage Objektes wird erstellt.
	 * Mithilfe von zwei verschachtelten for-Schleifen wird das gesamte Bild (Original) durchlaufen.
	 * Zuerst wird an jeder Stelle des Arrays "median" der Index des hellsten Zeichens gespeichert.
	 * Danach wird der Index (Helligkeitswert) des gegenwärtig betrachteten Zeichens (Index der Laufvariablen der for-Schleifen) an der mittleren Position des Arrays gespeichert.
	 * Daraufhin werden alle acht Positionen, um den aktuellen Koordinaten herum, betrachtet. Sind die Positionen innerhalb des Bildes, werden die 
	 * entsprechenden Helligkeitswerte in "median" gespeichert. Im gegenteiligen Fall geschieht nichts.
	 * Zuletzt werden die Werte des Arrays aufsteigend sortiert und die entsprechenden Zeichen im Bild (Kopie) gesetzt.*/
	public AsciiImage execute(AsciiImage img){

		char m = ' ';
		int cnt = 0;
		this.img = img;
		AsciiImage result = new AsciiImage(img);

		for(int g=0;g<result.getHeight();g++){
			for(int h=0;h<result.getWidth();h++){
				Arrays.fill(median, result.getCharset().length()-1);
				median[4] = getIndex(h,g);	

				if(g>0 && h>0){
					median[0] = getIndex(h-1,g-1);
				} 
				if(g>0){
					median[1] = getIndex(h, g-1);
				}
				if(g>0 && h<result.getWidth()-1){
					median[2] = getIndex(h+1,g-1);
				}
				if(h>0){
					median[3] = getIndex(h-1,g);
				}
				if(h<result.getWidth()-1){
					median[5] = getIndex(h+1,g);
				}
				if(g<result.getHeight()-1 && h>0){
					median[6] = getIndex(h-1,g+1);
				}
				if(g<result.getHeight()-1){
					median[7] = getIndex(h,g+1);
				}
				if(g<result.getHeight()-1 && h<result.getWidth()-1){
					median[8] = getIndex(h+1,g+1);
				}

				Arrays.sort(median);
				result.setPixel(h,g,result.getCharset().charAt(median[4]));
			}
		}
		return result;
	}
	/**
	 * Helligkeitswerte der Zeichen.
	 * @param a x-Koordinate des Bildes.
	 * @param b y-Koordinate des Bildes.
	 * @return Gibt den Helligkeitswert des Zeichens an den angegebenen Koordinaten als Integer zurück.*/
	int getIndex(int a, int b){
		return img.getCharset().indexOf(img.getPixel(a,b));
	}
}
