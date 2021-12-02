public class InvalidTurnException extends Exception{

	public InvalidTurnException(){
		super ("Invalid entry for turn");
	}
	public InvalidTurnException(String message){
		super(message);
	}
}