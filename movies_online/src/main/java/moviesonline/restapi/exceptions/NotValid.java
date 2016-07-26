package moviesonline.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Not Valid")
public class NotValid extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotValid(String message) {
		super(message);
	}

	public NotValid(String message, Throwable cause) {
		super(message, cause);
	}
}
