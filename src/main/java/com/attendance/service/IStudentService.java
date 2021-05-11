package com.attendance.service;

import java.util.List;

import com.attendance.entity.Student;

public interface IStudentService {

	public List<Student> listarTodos();
	public void guardar(Student student);
	public Student buscarPorId(Long id);
	public void eliminar(Long id);
}
