package com.attendance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attendance.entity.Attendance;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

}
