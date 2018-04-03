package ng.kennie.rest.model.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
public class HealthCheckController {

	@Autowired
	private RequestMappingHandlerMapping handlerMapping;

	@RequestMapping(value = "/endpoints", method = RequestMethod.GET)
	public void endpoints(final Model model) {
		model.addAttribute("handlerMethods", this.handlerMapping.getHandlerMethods());
	}

	@RequestMapping(path = "/healthCheck", method = RequestMethod.GET)
	public String healthCheck() {
		return "{status: \"Service Healthy\"}";
	}

}
