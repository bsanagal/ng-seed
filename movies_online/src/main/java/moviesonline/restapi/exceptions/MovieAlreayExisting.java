package moviesonline.restapi.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "USER ALREADY EXISTS")
public class MovieAlreayExisting extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MovieAlreayExisting(String message) {
		super(message);
	}

	public MovieAlreayExisting(String message, Throwable cause) {
		super(message, cause);
	}
}
