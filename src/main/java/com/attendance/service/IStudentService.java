package com.attendance.service;

import java.util.List;

import com.attendance.entity.Student;

public interface IStudentService {
	
	// Methods that the class "StudentServiceImp" will inherit
	public List<Student> listarTodos();
	public void save(Student student);
	public Student buscarPorId(Long id);
	public void delete(Long id);
}
