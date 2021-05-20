package com.attendance.controller;

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


// Java annotation that defines the class as a controller
@Controller

// Mapping that will have all the methods in it
@RequestMapping("/views")
public class AttendanceController {
	
	// Import the Service from the two entities (Attendance) and (Student) with @Autowired
	@Autowired
	private IAttendanceService attendanceService;
	@Autowired
	private IStudentService studentService;
	
	
	/* Mapping ("http://localhost:9443/views/index/{id}") depending on the attendance we select */
	@GetMapping("/index/{id}")
	public String editar(@PathVariable("id") Attendance attendance, Model model) {
		
		// Format to LocalDateTime(day/month/year hour:minutes) example:(12/05/2020 20:34)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		// List of Student that receives the data from the data base of all Students
		List<Student> studentList = studentService.listarTodos();
		
		// Import the format to DateTimeLocal of attendance
		String date = formatter.format(attendance.getDateTime());		
		String name = attendance.getName();
		Integer present = attendance.getPresent();
		Integer absent = attendance.getAbsent();
		Integer excused = attendance.getExcused();
		Integer late = attendance.getLate();
		Integer leftEarly = attendance.getLeftEarly();
				
		// Import the model studentList to "attendanceStudent.html" that has the list of Students
		model.addAttribute("student", studentList);
		
		// Import the model date and name to "index.html" to show the date of the attendance
		model.addAttribute("date", date);
		model.addAttribute("name", name);
		model.addAttribute("present", present);
		model.addAttribute("absent", absent);
		model.addAttribute("excused", excused);
		model.addAttribute("late", late);
		model.addAttribute("leftEarly", leftEarly);
		
		return "views/index";
	}
	
	/* Mapping ("http://localhost:9443/views/add") create attendances with name and LocalDateTime */
	@GetMapping("/add")
	public String add(Model model) {
		
		// Create an instance of our object Attendance to import name and LocalDateTime of our "add.html"
		Attendance attendance = new Attendance();
		
		// Import the model attendance to "add.html" to use as an object
		model.addAttribute(attendance);
		
		return "views/add";
	}
	
	/* Controller to the button "Create" that saves the object and redirects to our attendances list
	 * (params="actions=save") equals to (value="save") of "add.html"
	 */
	@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=save")
	public String save(@Valid @ModelAttribute Attendance miAttendance, BindingResult result, Model model) {
		
		// Save the attendance with the name and LocalDateTime, plus the other attributes initialized to 0
		attendanceService.save(miAttendance);
		
		return "redirect:/views/attendance";
	}
	
	/* Controller to the button "Create & Add Another" that saves the object and redirects to the attendance creation
	 * (params="actions=saveOther") equals to (value="saveOther") of "add.html"
	 */
	@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=saveOther")
	public String saveOther(@Valid @ModelAttribute Attendance attendance, BindingResult result, Model model) {
		
		// Save the attendance with the name and LocalDateTime, plus the other attributes initialized to 0
		attendanceService.save(attendance);
		
		return "redirect:/views/add";
	}

	/* Controller to the button "Cancel" that redirects to add.html resetting the inputs
	 * (params="actions=cancel") equals to (value="cancel") of "add.html"
	 */
	@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=cancel")
	public String cancel(Model model) {
		
		// Create a new instance of our object Attendance to import name and LocalDateTime of our "add.html"
		Attendance attendance = new Attendance();
				
		// Import the model attendance to "add.html" to use as an object
		model.addAttribute(attendance);
		
		return "redirect:/views/add";
	}
	
	/* Mapping ("http://localhost:9443/views/attendance") */
	@GetMapping("/attendance")
	public String attendance(Model model, Attendance attendance) {
	
		// List of Attendance that receives the data from the data base of all the Attendances
		List<Attendance> attendanceList = attendanceService.listarTodos();
		
		// Import the model attendanceList to "attendance.html" that has the list of Attendances
		model.addAttribute("attendance", attendanceList);
		
		return "views/attendance";
	}
	
	/* Mapping ("http://localhost:9443/views/attendanceStudent") */
	@GetMapping("/attendanceStudent")
	public String attendanceStudent(Model model) {
		
		// List of Student that receives the data from the data base of all Students
		List<Student> studentList = studentService.listarTodos();
		
		// Import the model studentList to "attendanceStudent.html" that has the list of Students
		model.addAttribute("student", studentList);
		
		return "views/attendanceStudent";
	}
	
	/* Mapping ("http://localhost:9443/views/exportImport") */
	@GetMapping("/exportImport")
	public String exportImport() {
		
		return "views/exportImport";
	}
	
}




