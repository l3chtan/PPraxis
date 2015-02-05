import java.util.Scanner;

/**
 * Diese Klasse erzeugt ein neues BinaryOperation Objekt.
 * Sie implementiert die Factory Klasse.*/

public class BinaryFactory implements Factory {

	/**
	 * Konstruktor. 
	 * Erzeugt ein neues Objekt von BinaryFactory.*/
	public BinaryFactory(){
	}

	/**
	 * Erzeugt eine neue BinaryOperation.
	 * Um eine neue BinaryOperation zu erzeugen wird noch ein Argument mithilfe des übergebenen Scanners eingelesen.
	 *
	 * @param scanner Wird benötigt um weitere Parameter einzulesen.
	 * @return ein neues Objekt der BinaryOperation Klasse.
	 * @throws FactoryException Wirft eine Ausnahme, wenn keine Parameter eingelesen werden können.*/
	public Operation create(Scanner scanner) throws FactoryException{

		String s = "";
		char threshold = ' ';

		if(!scanner.hasNext()){
			throw new FactoryException("Kein Zeichen zum Einlesen vorhanden");
		}
		s = scanner.next();
		threshold = s.charAt(0);

		return new BinaryOperation(threshold);
	}
}
