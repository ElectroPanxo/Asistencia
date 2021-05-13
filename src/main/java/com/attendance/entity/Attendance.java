package com.attendance.entity;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "attendance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private int present;
	
	@NotEmpty
	private int absent;
	
	@NotEmpty
	private int excused;
	
	@NotEmpty
	private int late;
	
	@NotEmpty
	private int leftEarly;
	
	@NotEmpty
	private Date dateTime;
	
	@NotEmpty
	public String checkDate() {
	       
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
       
        String date = formatter.format(this.dateTime);
       
        return date;
    }
	
}
