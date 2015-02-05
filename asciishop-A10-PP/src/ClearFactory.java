import java.util.Scanner;

/**
 * Diese Klasse kann ein neues Objekt der Klasse ClearOperation erzeugen.
 * Sie implementiert Factory.
 * */
public class ClearFactory implements Factory {
	
	/**
	 * Konstruktor.
	 * Erzeugt ein neues Objekt dieser Klasse.*/
	public ClearFactory(){
	}

	/**
	 * Diese Methode erzeugt ein neues Objekt von ClearOperation.
	 *
	 * @param scanner Wird in dieser Methode nicht verwendet.
	 * @return Eine neue ClearOperation.*/
	public Operation create(Scanner scanner){
		
		return new ClearOperation();
	}
}
