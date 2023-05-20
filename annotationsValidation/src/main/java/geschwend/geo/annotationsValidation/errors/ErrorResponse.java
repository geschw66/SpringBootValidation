package geschwend.geo.annotationsValidation.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author George C. Geschwend
 * @date 5/20/2023 4:08 PM
 * @project SpringBootValidation
 */
@Getter
@Setter
public class ErrorResponse{

    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy hh:mm:ss")
    private Date errorTimestamp;

    private int  errorCode;

    private String errorDescription;

    private String errorMessage;

    private String errorSource;

    public ErrorResponse(int errorCode, String errorDescription, String errorMessage){

        this.errorTimestamp = new Date();
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.errorMessage = errorMessage;
        this.errorSource = "VALIDATION_DEMO_SERVICE";
    }
}
