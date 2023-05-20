package geschwend.geo.annotationsValidation.DTO.requests;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author George C. Geschwend
 * @date 5/20/2023 2:21 PM
 * @project SpringBootValidation
 *
 * This is a POJO representation of the outer JSON "title" block that contains the inner blocks that hold the actual
 *  data to be validated. You need to place an additional @Valid annotation here on the outer block so that validation will
 *  happen within the blocks you want to validate.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateDataRequestWrapper {
    /* Valid needed to validate the data in the inner block of JSON */
    @Valid
    ValidateDataRequest validateDataRequest;
}
