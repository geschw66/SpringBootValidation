package geschwend.geo.annotationsValidation.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author George C. Geschwend
 * @date 5/20/2023 3:46 PM
 * @project SpringBootValidation
 *
 * Using this class mostly for repackaging the messages from the exceptions, and also to get a standardized format for
 * error and exception responses.
 *
 * The <code>@ControllerAdvice</code> annotation is used to define global exception handling and data binding rules for
 * all the controllers in your application. It allows you to consolidate your exception handling and apply it
 * consistently across multiple controllers (ergo a uniformed format for all the exceptions).
 */
@ControllerAdvice
public class CustomControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(Exception e) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        String message;
        /* Create a default message in case none is provided. */
        if (e.getMessage() == null || e.getMessage().isBlank() )
        {
            message = "MethodArgumentNotValidException has been thrown: check the format of your request.";
        } else {
            /* Have to do these shenanigans in order to get the message from the validation annotation */
            message = e.getMessage().substring(e.getMessage().lastIndexOf("[") + 1,e.getMessage().lastIndexOf("]") - 1);
        }

        return new ResponseEntity<>(
                new ErrorResponse(
                        status.value(),
                        "METHOD_ARGUMENT_NOT_VALID_EXCEPTION",
                         message), status);
    }
}
