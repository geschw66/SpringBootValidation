package geschwend.geo.annotationsValidation.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author George C. Geschwend
 * @date 5/20/2023 1:58 PM
 * @project SpringBootValidation
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeDTO {

    @JsonProperty("validated")
    private boolean validated;
}
