package geschwend.geo.annotationsValidation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import geschwend.geo.annotationsValidation.DTO.responses.HomeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import geschwend.geo.annotationsValidation.DTO.requests.ValidateDataRequestWrapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * @author George C. Geschwend
 * @date 5/20/2023 10:53 AM
 * @project SpringBootValidation
 *
 * Controller portion for demonstrating the use of @Valid.
 */
@RestController
public class HomeController {

    private static final Logger log = LogManager.getLogger(HomeController.class);

    /**
     * Simple controller method to demonstrate the validation annotations. Mostly concerned with whether the parameters
     * exist in the body of the incoming request.
     */
    @PostMapping(path = "/home", produces = "application/json")
    public ResponseEntity<String> home(@Valid @RequestBody ValidateDataRequestWrapper validateDataRequestWrapper) throws JsonProcessingException {

        log.info("HomeController called! Testing validation annotations: Request message must be valid.");

        String validated = createResponse();

        log.info("SENT MESSAGE:\n\n{}", validated);
        return new ResponseEntity<>(validated, HttpStatus.OK);
    }

    /**
     * Creates a pretty response for the home controller; mostly for logging purposes.
     *
     * @return A successful response with a value of true else returns an exception
     * @throws JsonProcessingException Indicates an error during the processing or parsing of JSON data.
     */
    private String createResponse() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String greeting = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new HomeDTO(true));
        return greeting;
    }


}
