package com.attendance.service;

import java.util.List;

import com.attendance.entity.Attendance;



public interface IAttendanceService {

	public List<Attendance> listarTodos();
	public void guardar(Attendance attendance);
	public Attendance buscarPorId(Long id);
	public void eliminar(Long id);
}
