package com.AssignmentSpringBoot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckOutController {

	@RequestMapping("/checkOut")
	public String CheckOut() {
		return "checkOut";
	}
}