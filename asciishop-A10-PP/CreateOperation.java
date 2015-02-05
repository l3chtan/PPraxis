public class CreateOperation implements Operation{

	private int width, height;
	private String charset;

	/**
	 * Konstruktor.
	 * Erzeugt eine neue Instanz von CreateOperation. 
	 * Er übernimmt auch die Höhe, Breite und das charset und speichert sie in Klassenvariablen.*/
	public CreateOperation(int width, int height, String charset){
		this.width = width;
		this.height = height;
		this.charset = charset;

	}

	/**
	 * Methode um die Operation auszuführen.
	 * Erstellt ein neues AsciiImage mit den übergebenen Werten und setzt alle Werte auf das Hellste Zeichen.
	 * @param img Wird hier nicht verwendet.
	 * @return eine neue ClearOperation, die alle Zeichen des Bildes auf das Hintergrundzeichen setzt.*/
	public AsciiImage execute(AsciiImage img) throws OperationException{

		AsciiImage result = new AsciiImage(width, height, charset);

		return new ClearOperation().execute(result);
	}
}
