import java.util.Scanner;

/**
 * Diese Klasse erzeugt eine neues LoadOperation.
 * Sie implementiert Factory.*/
public class LoadFactory implements Factory {

	/**
	 * Konstruktor.
	 * Erzeugt eine neue Instant dieser Klasse.*/
	public LoadFactory(){
	}

	/**
	 * Lädt die Bilddaten aus der Eingabedatei.
	 * Um eine neue LoadOperation zu erzeugen liest diese Methode aus der Eingabedatei das EOF und das Bild selbst ein.
	 * 
	 * @param scanner Liest sowohl das EOF (vor und nach dem Bild) als auch das Bild ein.
	 * @return Ein neues Objekt der Klasse LoadOperation mit dem eingelesenen Bild als String.
	 * @throws FactoryException Wird geworfen, wenn vor dem Bild kein EOF Befehl steht, bzw. wenn es am Ende des Bildes nicht vor kommt.*/
	public Operation create(Scanner scanner) throws FactoryException {

		String eof = "", temp = "", loot = "";

		if(scanner.hasNext()){
			eof = scanner.next();
		} else {
			throw new FactoryException("EOF fehlt");
		}
		while(!loot.equals(eof)){
			temp += loot + '\n';
			loot = scanner.next();
		}
		if(!loot.equals(eof)){
			throw new FactoryException("Das Bild nimmt kein Ende");
		}

		return new LoadOperation(temp);
	}
}
