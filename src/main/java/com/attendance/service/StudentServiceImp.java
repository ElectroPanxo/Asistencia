package com.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.entity.Student;
import com.attendance.repository.StudentRepository;

@Service
public class StudentServiceImp implements IStudentService{

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> listarTodos() {	
		return (List<Student>)studentRepository.findAll();
	}

	@Override
	public void guardar(Student student) {
		studentRepository.save(student);	
	}

	@Override
	public Student buscarPorId(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		studentRepository.deleteById(id);	
	}
	
}
