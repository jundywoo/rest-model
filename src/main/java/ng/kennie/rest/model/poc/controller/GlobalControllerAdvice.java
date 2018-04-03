package ng.kennie.rest.model.poc.controller;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages = { "ng.kennie.rest.model.poc.controller" })
public class GlobalControllerAdvice {
	@InitBinder
	public void dataBinding(final WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, true));
	}

	@ModelAttribute
	public void globalAttributes(final Model model) {
		model.addAttribute("msg", "Welcome to My World!");
	}

	@ExceptionHandler(FileNotFoundException.class)
	public ModelAndView myError(final Exception exception) {
		final ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.setViewName("error");
		return mav;
	}
}
