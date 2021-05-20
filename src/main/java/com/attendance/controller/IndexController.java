package com.attendance.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.attendance.entity.Attendance;


@Controller
public class IndexController {
	

	@GetMapping({"/index", "/"})
	public String index(Model model, Attendance attendance) {
		
		return "redirect:/views/attendance";
	}

}

