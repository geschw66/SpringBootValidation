package exceptions;

/**
 * @author George C. Geschwend
 * @date 5/20/2023 3:10 PM
 * @project SpringBootValidation
 *
 * Need to handle unexpected run time exceptions
 */
public class MiscException extends RuntimeException {

    public MiscException() {
        super();
    }
    public MiscException(String message) {
        super(message);
    }
}
