package com.attendance.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.attendance.entity.Attendance;

// Java annotation that defines the class as a Controller
@Controller

public class IndexController {
	
	// Mapping ("http://localhost:9443/") or ("http://localhost:9443/index") that redirects to "attendance.html" 
	@GetMapping({"/", "/index"})
	public String index(Model model, Attendance attendance) {
		
		// Return to the html "attendance" located in "views"
		return "redirect:/views/attendance";
	}

}

