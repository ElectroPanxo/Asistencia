package com.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.entity.Attendance;
import com.attendance.repository.AttendanceRepository;

@Service
public class AttendanceServiceImp implements IAttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;

	@Override
	public List<Attendance> listarTodos() {		
		return (List<Attendance>)attendanceRepository.findAll();
	}

	@Override
	public void guardar(Attendance attendance) {
		attendanceRepository.save(attendance);	
	}

	@Override
	public Attendance buscarPorId(Long id) {
		return attendanceRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		attendanceRepository.deleteById(id);		
	}

}
