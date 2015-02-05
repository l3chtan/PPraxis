public class PixelCountMetric implements Metric<AsciiImage>{

	/**
	 * Konstruktor.
	 * Erzeugt ein neues PixelCountMetric Objekt.*/
	public PixelCountMetric(){}

	/**
	 * Distanz zwischen zwei Bildern.
	 * Die Distanz ist ein Maß dafür wie ähnlich sich zwei Bilder sind.
	 * Je kleiner die Distanz ist, umso ähnlicher sind sich zwei Bilder.
	 * Hier wird die Distanz mithilfe der Pixelanzahl bestimmt. Die Differnz der Pixelzahlen ergibt die Distanz.
	 * @param o1 Erstes Bild für den Vergleich.
	 * @param o2 Zweites Bild für den Vergleich.
	 * @return Die Distanz zwischen den o1 und o2.*/
	public int distance(AsciiImage o1, AsciiImage o2){
		return Math.abs((o1.getWidth()*o1.getHeight())-(o2.getWidth()*o2.getHeight()));
	} 
}
