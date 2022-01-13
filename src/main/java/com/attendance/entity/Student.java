package com.attendance.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

// Java annotation that defines the class as an Entity
@Entity

// Defines which table will have the entity ("student")
@Table(name = "student")

// Group of Java annotations that allow "getters", "setters" and "toString()" to not appear in the code
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student implements Serializable {

	
	private static final long serialVersionUID = 1L;

	// Java annotation that defines which attribute will be main key
	@Id
	
	// Java annotation that defines that the attribute will be generated automatically
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/* Java annotation that defines that the attribute cannot be empty, if that occurs it will show
	a message */
	@NotEmpty(message="You have to enter a Photo")
	private String photo;
	
	@NotEmpty(message="You have to enter a Name")
	private String name;
	
	// Java annotation that defines the minimum value to 0
	@Min(0)
	private int present;
	
	@Min(0)
	private int absent;
	
	@Min(0)
	private int excused;
	
	@Min(0)
	private int late;
	
	@Min(0)
	private int leftEarly;
	
}