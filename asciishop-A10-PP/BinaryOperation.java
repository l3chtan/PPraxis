/**
 * Diese Klasse erstellt ein Binärbild.
 * Sie implementiert Operation.*/
public class BinaryOperation implements Operation {

	private char threshold;

	/**
	 * Konstruktor.
	 * Erzeugt eine neues Instanz dieser Klasse mit dem Parameter "threshold".
	 * @param threshold Dieser Parameter bestimmt welche Zeichen aus dem charset auf das dunkelste, bzw. hellste Zeichen gesetzt werden.*/
	public BinaryOperation(char threshold){
		this.threshold = threshold;
	}

	/**
	 * Erzeugt ein neues AsciiImage, mit einem Binärbild.
	 * Die Methode durchläuft das ganze Bild und setzt alle Pixel, die dünkler als "threshold" sind auf das dünkelste Zeichen, und alle anderen (threshold eingeschlossen) auf das hellste Zeichen.
	 *
	 * @param img Das AsciiImage, aus dessen Werten, das Binärbild erzeugt wird.
	 * @return Das Binärbild in einem neuen AsciiImage Objekt.
	 * @throws OperationException Wird geworfen, wenn "threshold" nicht Teil des charsets aus "img" ist.*/
	public AsciiImage execute(AsciiImage img) throws OperationException{

		String chars = img.getCharset();
		int ind = chars.indexOf(threshold);
		if(ind == -1){
			throw new OperationException("Übergebenes Zeichen ist nicht Teil des charsets.");
		}

		AsciiImage result = new AsciiImage(img);

		for(int i=0;i<img.getHeight();i++){
			for(int j=0;j<img.getWidth();j++){
				if(chars.indexOf(img.getPixel(j,i))<ind){
					result.setPixel(j,i,chars.charAt(0));
				} else {
					result.setPixel(j,i,chars.charAt(chars.length()-1));
				}
			}
		}
		return result;
	}
}
