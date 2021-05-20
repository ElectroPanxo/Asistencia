package com.attendance.service;

import java.util.List;

import com.attendance.entity.Attendance;

public interface IAttendanceService {

	// Methods that the class "AttendanceServiceImp" will inherit
	public List<Attendance> listarTodos();
	public void save(Attendance attendance);
	public Attendance buscarPorId(Long id);
	public void delete(Long id);
}
