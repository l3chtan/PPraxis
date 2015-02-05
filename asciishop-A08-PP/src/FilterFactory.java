import java.util.Scanner;

/**
 * Diese Klasse enthält eine Methode zum erstellen einer MedianOperation.
 * Sie implementiert Factory.*/
public class FilterFactory implements Factory{

	/**
	 * Konstruktor.
	 * Erzeugt ein neues FilterFactory Objekt.*/
	public FilterFactory(){
	}

	/**
	 * Erstellt eine neue MedianOperation.
	 *
	 * @param scanner Liest den Befehl "median" ein.
	 * @return Eine neue Instanz von MedianOperation.
	 * @throws FactoryExcpetion Wird geworfen, wenn der eingelesene Befehl nicht "median" ist.*/
	public Operation create(Scanner scanner) throws FactoryException {
	
		if(!scanner.next().equals("median")){
			throw new FactoryException("Ungenügender Befehl");
		}
		return new MedianOperation();
	}



}
