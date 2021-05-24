package com.attendance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attendance.entity.Attendance;

// Java annotation that defines the class as a Repository
@Repository

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

}
