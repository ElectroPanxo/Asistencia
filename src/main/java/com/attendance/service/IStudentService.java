package com.attendance.service;

import java.util.List;

import com.attendance.entity.Student;

public interface IStudentService {
	
	// Methods that the class "StudentServiceImp" will inherit
	public List<Student> listAll();
	public void save(Student student);
	public Student searchById(Long id);
	public void delete(Long id);
}
