package pw.io.booker.exception;

public class InvalidAuthException extends RuntimeException{

	private final String message;
	
	public InvalidAuthException(String message)
	{
		super();
		this.message = "Access denied. " + message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}
	
}
