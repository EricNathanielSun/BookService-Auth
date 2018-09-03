package pw.io.booker.exception;

public class InvalidUsernameOrPasswordException extends RuntimeException{

	private final String userFriendlyMessage = "Invalid Username Or Password";
	
	@Override
	public String getMessage()
	{
		return userFriendlyMessage;
	}
	
}
