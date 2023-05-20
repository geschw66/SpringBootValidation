package geschwend.geo.annotationsValidation.DTO.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;


/**
 * @author George C. Geschwend
 * @date 5/20/2023 2:22 PM
 * @project SpringBootValidation
 *
 * This POJO is used to hold the incoming message parameters; the data block.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateDataRequest {

    @JsonProperty("id")
    @Valid
    @NotBlank(message = "parameter 'id' is mandatory")
    @Pattern(regexp = "^\\d+$", message = "parameter 'id' uses only numeric characters.")
    private String id;

    @JsonProperty("firstName")
    @Valid
    @NotBlank(message = "parameter 'firstName' is mandatory")
    private String firstName;

    @JsonProperty("lastName")
    @Valid
    @NotBlank(message = "parameter 'lastName' is mandatory")
    private String lastName;
}
