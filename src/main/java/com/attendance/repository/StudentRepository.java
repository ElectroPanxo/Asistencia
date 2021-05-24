package com.attendance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attendance.entity.Student;

// Java annotation that defines the class as a Repository
@Repository

public interface StudentRepository extends CrudRepository<Student, Long> {

}