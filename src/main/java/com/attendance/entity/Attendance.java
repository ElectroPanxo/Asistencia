package com.attendance.entity;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

// Java annotation that defines the class as an Entity
@Entity

// Defines which table will have the entity ("attendance")
@Table(name = "attendance")

// Group of Java annotations that allow "getters", "setters" and "toString()" to not appear in the code
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Attendance implements Serializable {

	
	private static final long serialVersionUID = 1L;

	// Java annotation that defines which attribute will be main key
	@Id
	
	// Java annotation that defines that the attribute will be generated automatically
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/* Java annotation that defines that the attribute cannot be empty, if that occurs it will show
	a message */
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
	
	/* Java annotation that defines that the attribute cannot be "null" value, if that occurs it will show
	a message */
	@NotNull(message="You have to enter a Date")
	
	// Java annotation that defines the pattern of the LocalDateTime to (yyyy-MM-dd'T'HH:mm)
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dateTime;
    
    // Method that formats the LocalDate to (dd/MM/yyyy HH:mm)
    public String checkDate() {
	       
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		String fecha = formatter.format(this.dateTime);
       
        return fecha;
    }
	
	
}
