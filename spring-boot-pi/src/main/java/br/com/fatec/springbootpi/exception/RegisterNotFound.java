package br.com.fatec.springbootpi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RegisterNotFound extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    public RegisterNotFound() {
        super();
    }

    public RegisterNotFound(String message) {
        super(message);
    }

    public RegisterNotFound(Throwable cause) {
        super(cause);
    }

    public RegisterNotFound(String message, Throwable cause) {
        super(message, cause);
    }
<<<<<<< HEAD

=======
>>>>>>> 8a39a4b7550dd4443eb753d2a5a736bc27880914
}