package com.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attendance.entity.Attendance;
import com.attendance.entity.Student;
import com.attendance.service.AttendanceServiceImp;
import com.attendance.service.IAttendanceService;
import com.attendance.service.IStudentService;



@Controller
@RequestMapping("/views")
public class AttendanceController {
	
	@Autowired
	private IAttendanceService attendanceService;
	@Autowired
	private IStudentService studentService;
	
	@GetMapping("/add")
	public String pepe() {
		return "views/add";
	}
	
	@GetMapping("/attendance")
	public String attendance(Model model) {
		List<Attendance> attendanceList = attendanceService.listarTodos();
		
		model.addAttribute("attendance", attendanceList);
		
		return "views/attendance";
	}
	
	@GetMapping("/attendanceStudent")
	public String attendanceStudent(Model model) {
		List<Student> studentList = studentService.listarTodos();
		
		model.addAttribute("student", studentList);
		
		return "views/attendanceStudent";
	}
	
	
	@GetMapping("/exportImport")
	public String exportImport() {
		return "views/exportImport";
	}
	
	@GetMapping("/check/{id}")
	public String check() {
		return null;
	}

}
