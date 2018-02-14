package ng.kennie.rest.model.poc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ng.kennie.rest.model.poc.model.RequestModel;

@RestController()
public class RestModelPocController {

	private final Logger LOGGER = LoggerFactory.getLogger(RestModelPocController.class);

	@RequestMapping(path = "/pocPostObject", method = RequestMethod.POST)
	public String pocPostObject(@Validated @RequestBody final RequestModel model) {
		LOGGER.info(model.toString());

		return "Success getting Object";
	}
}
