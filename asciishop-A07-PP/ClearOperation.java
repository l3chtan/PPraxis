public class ClearOperation implements Operation{
	
	/**
	 * Konstruktor.
	 * */
	public ClearOperation(){
	}
	
	/**
	 * Setzt alles Zeichen auf das hellste Zeichen.
	 * Die Methode erstellt eine Kopie des ursprünglichen Bildes und
	 * setzt in der Kopie alles Zeichen auf das, in Charset definierte, hellste Zeichen.
	 * @param img Das Bild dessen Kopie bearbeitet wird.
	 * @return Bearbeitete Kopie des übergebenen Bildes.*/
	public AsciiImage execute(AsciiImage img){

		AsciiImage result = new AsciiImage(img);

		for(int i=0;i<result.getWidth();i++){
			for(int j=0;j<result.getHeight();j++){
				result.setPixel(i,j, img.getCharset().charAt(img.getCharset().length()-1));
			}
		}
	return result;	
	}
}
