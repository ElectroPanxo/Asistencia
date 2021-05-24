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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.attendance.entity.Attendance;
import com.attendance.entity.Student;
import com.attendance.service.IAttendanceService;
import com.attendance.service.IStudentService;


// Java annotation that defines the class as a Controller
@Controller

// Mapping that will have all the methods in it
@RequestMapping("/views")
public class AttendanceController {
	
	// Import the Service from the two entities (Attendance) and (Student) with @Autowired
	@Autowired
	private IAttendanceService attendanceService;
	@Autowired
	private IStudentService studentService;
	
	
	// Mapping ("http://localhost:9443/views/index/{id}") depending on the attendance we select
	@GetMapping("/index/{id}")
	public String editar(@PathVariable("id") Attendance attendance, Model model) {
		
		// Format to LocalDateTime(day/month/year hour:minutes) example:(12/05/2020 20:34)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		// List of Student that receives the data from the data base of all Students
		List<Student> studentList = studentService.listAll();
		
		// Import the format to DateTimeLocal of attendance
		String date = formatter.format(attendance.getDateTime());
		
		// Variables with method get to obtain the information of the existing attendance
		String name = attendance.getName();
		Integer present = attendance.getPresent();
		Integer absent = attendance.getAbsent();
		Integer excused = attendance.getExcused();
		Integer late = attendance.getLate();
		Integer leftEarly = attendance.getLeftEarly();
		Long id = attendance.getId();
				
		// Import the model student to "attendanceStudent.html" that has the list of Students
		model.addAttribute("student", studentList);
		
		/* Import the model id, date, name, present, absent, excused, late and leftEarly to "index.html"
		   to show the date of the attendance */
		model.addAttribute("id", id);
		model.addAttribute("date", date);
		model.addAttribute("name", name);
		model.addAttribute("present", present);
		model.addAttribute("absent", absent);
		model.addAttribute("excused", excused);
		model.addAttribute("late", late);
		model.addAttribute("leftEarly", leftEarly);
		
		// Return to the html "index" located in "views"
		return "views/index";
	}
	
	// Mapping ("http://localhost:9443/views/add") create attendances with name and LocalDateTime
	@GetMapping("/add")
	public String add(Model model) {
		
		// Create an instance of our object Attendance to import name and LocalDateTime of our "add.html"
		Attendance attendance = new Attendance();
		
		// Import the model attendance to "add.html" to use as an object
		model.addAttribute(attendance);
		
		// Return to the html "add" located in "views"
		return "views/add";
	}
	
	/* Controller of the button "Create" that saves the object and redirects to our attendances list
	   (params="actions=save") equals to (value="save") of "add.html" */
	@RequestMapping(value="/save", method=RequestMethod.POST, params="action=save")
	public String save(@Valid @ModelAttribute Attendance miAttendance, BindingResult result, Model model) {
		
		// If there is an error, return the view "add" with the errors
		if(result.hasErrors()) {
			return "views/add";
		}
		
		// Save the attendance with the name and LocalDateTime, plus the other attributes initialized to 0
		attendanceService.save(miAttendance);
		
		// Redirects to the general view of all attendances
		return "redirect:/views/attendance";
	}
	
	/* Controller of the button "Create & Add Another" that saves the object and redirects to the
	   attendance creation(params="actions=saveOther") equals to (value="saveOther") of "add.html" */
	@RequestMapping(value="/save", method=RequestMethod.POST, params="action=saveOther")
	public String saveOther(@Valid @ModelAttribute Attendance attendance, BindingResult result, Model model) {
		
		// If there is an error, return the view "add" with the errors
		if(result.hasErrors()) {
			return "views/add";
		}
		
		// Save the attendance with the name and LocalDateTime, plus the other attributes initialized to 0
		attendanceService.save(attendance);
		
		// Redirects to the view "add" to continue adding attendances
		return "redirect:/views/add";
	}

	/* Controller of the button "Cancel" that redirects to add.html
	  (params="actions=cancel") equals to (value="cancel") of "add.html" */
	@RequestMapping(value="/save", method=RequestMethod.POST, params="action=cancel")
	public String cancel(Model model) {
		
		// Create a new instance of our object Attendance to import name and LocalDateTime of our "add.html"
		Attendance attendance = new Attendance();
				
		// Import the model attendance to "add.html" to use as an object
		model.addAttribute(attendance);
		
		// Redirects to the general view of all attendances
		return "redirect:/views/attendance";
	}
	
	/* Controller of the button "Update" that saves the object and redirects to our attendances list
	   (params="actions=update") equals to (value="update") of "update.html" */
	@RequestMapping(value="/update", method=RequestMethod.POST, params="action=update")
	public String update(@Valid @ModelAttribute Attendance miAttendance, BindingResult result, Model model) {
		
		// If there is an error, return the view "update" with the errors
		if(result.hasErrors()) {
			return "views/update";
		}
		// Save the attendance with the name and LocalDateTime, plus the other attributes initialized to 0
		attendanceService.save(miAttendance);
		
		// Redirects to the general view of all attendances
		return "redirect:/views/attendance";
	}
	
	/* Controller of the button "Cancel" that redirects to index.html
	  (params="actions=cancel") equals to (value="cancel") of "update.html" */
	@RequestMapping(value="/update", method=RequestMethod.POST, params="action=cancelUpdate")
	public String cancelUpdate(Model model, @ModelAttribute Attendance miAttendance) {
		
		// Create a new instance of our object Attendance to import name and LocalDateTime of our "add.html"
		Attendance attendance = new Attendance();
				
		// Import the model attendance to "index.html" to use as an object
		model.addAttribute(attendance);
		
		// Redirects to the index page of the attendance we wanted to edit
		return "redirect:/views/index/" + miAttendance.getId();
	}
	
	// Mapping ("http://localhost:9443/views/attendance") 
	@GetMapping("/attendance")
	public String attendance(Model model, Attendance attendance) {
	
		// List of Attendance that receives the data from the data base of all the Attendances
		List<Attendance> attendanceList = attendanceService.listAll();
		
		// Import the model attendance to "attendance.html" that has the list of Attendances
		model.addAttribute("attendance", attendanceList);
		
		// Return to the html "attendance" located in "views"
		return "views/attendance";
	}
	
	// Mapping ("http://localhost:9443/views/attendanceStudent") 
	@GetMapping("/attendanceStudent")
	public String attendanceStudent(Model model) {
		
		// List of Student that receives the data from the data base of all Students
		List<Student> studentList = studentService.listAll();
		
		// Import the model student to "attendanceStudent.html" that has the list of Students
		model.addAttribute("student", studentList);
		
		// Return to the html "attendanceStudent" located in "views"
		return "views/attendanceStudent";
	}
	
	// Mapping ("http://localhost:9443/views/exportImport") 
	@GetMapping("/exportImport")
	public String exportImport() {
		
		// Return to the html "exportImport" located in "views"
		return "views/exportImport";
	}
	
	// Mapping ("http://localhost:9443/views/edit/{id}") depending on the attendance we want to edit 
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long idAttendance, Model model) {

		Attendance attendance = null;

		// If the id of the attendance is higher than 0 it will search the object by the id of the attendance
		if (idAttendance > 0) {
			attendance = attendanceService.searchById(idAttendance);

			// If the searched attendance has no data, an error will appear
			if (attendance == null) {
				System.out.println("The id doesn't exists");
				return "redirect:/";
			}
		} 
		
		// Other cases will generate an error
		else {
			System.out.println("Error with the id");
			return "redirect:/";
		}
		
		/* Import the model attendance with the data of the attendance we wanted to edit to "update.html"
		   to fill the inputs with the existing data */
		model.addAttribute("attendance", attendance);

		// Return to the html "update" located in "views"
		return "views/update";
	}
	
}




