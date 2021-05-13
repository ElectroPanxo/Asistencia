package com.attendance.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attendance.entity.Attendance;
import com.attendance.entity.Student;
import com.attendance.service.IAttendanceService;
import com.attendance.service.IStudentService;



@Controller
@RequestMapping("/views")
public class AttendanceController {
	
	@Autowired
	private IAttendanceService attendanceService;
	@Autowired
	private IStudentService studentService;
	
	@GetMapping("/index/{id}")
	public String editar(@PathVariable("id") Attendance attendance, Model model) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		String fecha = formatter.format(attendance.getDateTime());
		model.addAttribute("fecha", fecha);
		
		return "views/index";
	}
	
	@GetMapping("/add")
	public String pepe() {
		return "views/add";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=save")
	public String save(@ModelAttribute Attendance attendance, Model model) {
		
			System.out.println("Errores en el formulario");
			
			
			model.addAttribute("attendance", attendance);
		
		attendanceService.guardar(attendance);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=saveOther")
	public String saveOther(@ModelAttribute Attendance attendance, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("attendance", attendance);
			System.out.println("Errores en el formulario");
			return "redirect:/views/add";
		}

		attendanceService.guardar(attendance);
		return "redirect:/views/add";
	}


	@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=cancel")
	public String cancel(@ModelAttribute Attendance attendance, Model model) {
		return "redirect:/views/add";
	}
	
	@GetMapping("/attendance")
	public String attendance(Model model, Attendance attendance) {
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




