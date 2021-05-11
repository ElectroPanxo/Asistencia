package com.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attendance.entity.Attendance;
import com.attendance.service.AttendanceServiceImp;
import com.attendance.service.IAttendanceService;



@Controller
@RequestMapping("/views")
public class AttendanceController {
	
	@Autowired
	private IAttendanceService attendanceService;
	
	@GetMapping("/add")
	public String pepe() {
		return "views/add";
	}
	
	@GetMapping("/attendance")
	public String attendance(Model model) {
		
		List<Attendance> attendanceList = attendanceService.listarTodos();
		
		model.addAttribute("attendances",attendanceList);
		
		return "views/attendance";
	}
	
	@GetMapping("/attendanceStudent")
	public String attendanceStudent() {
		return "views/attendanceStudent";
	}
	
	
	@GetMapping("/exportImport")
	public String exportImport() {
		return "views/exportImport";
	}
	

}
