public class FactoryException extends Exception {

	public FactoryException(){
		super("INPUT MISMATCH");	
	}

	public FactoryException(String message){
		super(message);
	}
} 
