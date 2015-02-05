import java.util.Scanner;

/**
 * Ein interface zum erstellen von Factory Klassen.
 * Alle *Factory Klassen implementieren dieses interface.*/

public interface Factory {

	/**
	 * Erzeugt eine neue Operation und gibt diese zurück.
	 *
	 * @param scanner Der Scanner der Hauptklasse wird hier übergeben. Er wird verwendet um zusätzliche Argumente einzulesen, wenn diese notwendig sind.
	 * @return Eine neue Operation, die erzeugt wurde.
	 * @throws FactoryException Fehlerhafte Argumente, die über scanner eingelesen wurden werfen diese Ausnahme.*/
	public Operation create(Scanner scanner) throws FactoryException;
}
