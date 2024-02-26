// SimCardController.java
package au.com.telstra.simcardactivator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimCardController {

    @Value("${actuator.url}")
    private String actuatorUrl;

    private final RestTemplate restTemplate;

    public SimCardController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/activate")
    public ResponseEntity<String> activateSimCard(@RequestBody SimCardRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Construct the request payload
        SimCardActuatorRequest actuatorRequest = new SimCardActuatorRequest(request.getIccid());

        // Create the request entity
        HttpEntity<SimCardActuatorRequest> requestEntity = new HttpEntity<>(actuatorRequest, headers);

        // Send POST request to the actuator
        ResponseEntity<SimCardActuatorResponse> actuatorResponse = restTemplate.postForEntity(actuatorUrl, requestEntity, SimCardActuatorResponse.class);

     // Extract the success parameter from the actuator's response
        boolean activationSuccess = actuatorResponse.getBody().isSuccess();

        // Print whether activation was successful or not
        System.out.println("Received activation request:");
        System.out.println("ICCID: " + request.getIccid());
        System.out.println("Customer Email: " + request.getCustomerEmail());
        System.out.println("SIM card activation result: " + (activationSuccess ? "Success" : "Failure"));

        // You can return a success message or status here
        return ResponseEntity.ok("Activation request received");
    }
}
