public class OperationException extends Exception{

	public OperationException(){
		super("OPERATION FAILED");
	}

	public OperationException(String message){
		super(message);	
	}

}
