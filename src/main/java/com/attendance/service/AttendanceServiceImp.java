package com.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.entity.Attendance;
import com.attendance.repository.AttendanceRepository;

@Service
public class AttendanceServiceImp implements IAttendanceService {
	
	// Import Attendance Repository by using the @Autowired
	@Autowired
	private AttendanceRepository attendanceRepository;

	// Method listarTodos() to return a list of Attendances
	@Override
	public List<Attendance> listarTodos() {		
		return (List<Attendance>)attendanceRepository.findAll();
	}
	
	// Method save() that saves a Attendance in mySql server
	@Override
	public void save(Attendance attendance) {
		attendanceRepository.save(attendance);	
	}

	// Method buscarPorId() that search in the server by Id of the Attendance
	@Override
	public Attendance buscarPorId(Long id) {
		return attendanceRepository.findById(id).orElse(null);
	}

	// Method delete() that deletes a row in the mySql server searching by Id
	@Override
	public void delete(Long id) {
		attendanceRepository.deleteById(id);		
	}

}
