package vn.edu.vnua.dse.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/import/")
public class ImportController {
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String Create() {
		return "import/create";
	}
}
