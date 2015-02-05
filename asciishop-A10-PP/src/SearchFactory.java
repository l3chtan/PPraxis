import java.util.Scanner;

public class SearchFactory implements Factory {

	private MetricSet<AsciiImage> saved;

	/**
	 * Konstruktor.
	 * Erzeugt ein neues SearchFactory Objekt und übernimmt eine Liste von gespeicherten Bildern.
	 * @param saved Liste der gespeicherten Bilder.*/
	public SearchFactory(MetricSet<AsciiImage> saved){
		this.saved = saved;	
	}

	/**
	 * Create Befehl.
	 * Erzeugt eine neue SearchOperation mit unterschiedlichen Metriken.
	 * @param scanner Scanner um die Metrik festzustellen die angewandt werden soll.
	 * @return Eine neue SearchOperation.*/
	public Operation create(Scanner scanner) throws FactoryException {
		
		//String line = scanner.nextLine();
		String command = "";
		if(!scanner.hasNext()){
			throw new FactoryException("Not enough Argmunents");
		}
		command = scanner.next();
		if(!command.equals("pixelcount") && !command.equals("uniquechars")){
			throw new FactoryException(command + " is no valid command");
		}

		if(command.equals("pixelcount")){
			return new SearchOperation(saved, new PixelCountMetric());	
		} else {
			return new SearchOperation(saved, new UniqueCharsMetric());
		}
	}
}
