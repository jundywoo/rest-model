package ng.kennie.rest.model.poc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ng.kennie.rest.model.poc.model.RequestModel;

@RestController()
public class RestModelPocController {

	private final Logger LOGGER = LoggerFactory.getLogger(RestModelPocController.class);

	@RequestMapping(path = "/pocPostObject", method = RequestMethod.POST)
	public String pocPostObject(@RequestParam("requestModel") final RequestModel requestModel) {

		LOGGER.info(requestModel.toString());

		return "Success getting Object";
	}
}
