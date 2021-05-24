package com.attendance.service;

import java.util.List;

import com.attendance.entity.Attendance;

public interface IAttendanceService {

	// Methods that the class "AttendanceServiceImp" will inherit
	public List<Attendance> listAll();
	public void save(Attendance attendance);
	public Attendance searchById(Long id);
	public void delete(Long id);
}
