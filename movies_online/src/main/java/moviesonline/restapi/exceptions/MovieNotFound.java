package moviesonline.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Movie/TV NOT FOUND")
public class MovieNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovieNotFound(String message){
		super(message);
	}
	
	public MovieNotFound(String message, Throwable cause){
		super(message, cause);
	}
}
