package ng.kennie.rest.model.poc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@RequestMapping(path = "/healthCheck", method = RequestMethod.GET)
	public String healthCheck() {
		return "{status: \"Service Healthy\"}";
	}

}
