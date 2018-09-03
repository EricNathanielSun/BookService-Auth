package pw.io.booker.exception;

public class InvalidUsernameOrPasswordException extends Exception{

	private final String message = "Invalid Username Or Password";
	
	@Override
	public String getMessage()
	{
		return message;
	}
	
}
