public class SaveOperation implements Operation {

	private MetricSet<AsciiImage> saved;

	/**
	 * Konstruktor.
	 * Erzeugt eine neue Instanz von SaveOperation.
	 * Dem Konstruktor wird außerdem eine Liste übergeben in welche die Elemente gespeichert werden.
	 * @param saved Listenobjekt um Elemente zu speichern.*/
	public SaveOperation(MetricSet<AsciiImage> saved){
		this.saved = saved;
	}

	/**
	 * Methode um die eigentlich Operation auszuführen.
	 * Diese Methode speichert das übergebene Bild und erstellt eine Kopie des Originals.
	 * @param img Das zu speichernde Bild.
	 * @return eine Kopie von img.*/
	public AsciiImage execute(AsciiImage img) throws OperationException {
	
		AsciiImage result = new AsciiImage(img);

		if(!saved.add(img)){
			throw new OperationException("The image is already save");
		}

		return result;	
	}

	/**
	 * Methode für den Zugriff auf die gespeicherten Elemente.
	 * @return Gibt die Liste der gespeicherten Bilder zurück.*/
	public MetricSet<AsciiImage> getSaved(){
		return saved;
	}
}
