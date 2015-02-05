import java.util.Scanner;

public class CreateFactory implements Factory{


	/**
	 * Konstruktor.
	 * Der Default-Konstruktor.*/
	public CreateFactory(){}

	/**
	 * Erzeugende Methode.
	 * Erzeugt eine neue Operation, die ein Bild erzeugt.
	 * @param scanner Liest Höhe, Breite und den erlaubten Farbraum (charset).
	 * @return eine neue CreateOperation.*/
	public Operation create(Scanner scanner) throws FactoryException{

		int x = 0, y = 0;
		String charset = "";

		if(scanner.hasNextInt()){
			x = scanner.nextInt();
		} else {
			throw new FactoryException("Es wurde keine Bildbreite angegeben.");
		}
		if(scanner.hasNextInt()){
			y = scanner.nextInt();
		} else {
			throw new FactoryException("Es wurde keine Bildhöhe angegeben.");
		}
		if(scanner.hasNext()){
			charset = scanner.next();
		} else {
			throw new FactoryException("Es wurde kein gültiger Farbbereich angegeben.");	
		}
		return new CreateOperation(x, y, charset);
	}
}
