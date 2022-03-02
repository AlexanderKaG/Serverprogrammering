package se.yrgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tutor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // This line is optional
	private int Id;
	private String tutorId;
	private String name;
	private int salary;
	
	public Tutor() {
		
	}

	public Tutor(String tutorId, int salary) {
		this.tutorId = tutorId;
		this.salary = salary;
	}

	public String toString() {
		return String.format("ID: %d, Tutor ID: %s, Name: %s, Salary: %d");
	}
}

/*
 * private String tutorId private String name private int salary A constructor
 * with the above properties as arguments. Accessors (get methods) toString()
 */