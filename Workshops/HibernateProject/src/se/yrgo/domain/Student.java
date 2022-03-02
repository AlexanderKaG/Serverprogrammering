package se.yrgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // This line is optional
	private int Id;
	private String enrollmentID;
	private String name;
	private String tutorName; // This will become a class soon

	public Student() {

	}

	public Student(String name, String tutorName) {
		this.name = name;
		this.tutorName = tutorName;
	}

	public Student(String name) {
		this.name = name;
		this.tutorName = null;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public String toString() {
		return String.format("ID: %d, Name: %s, EnrollmentID: %s, Tutor: %s", Id, name, enrollmentID, tutorName);
	}
}
