package org.springapp.sboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/**
 * @author dreamboy
 *
 */

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping
	public ModelAndView main() {
		return new ModelAndView("main/main");
	}

}