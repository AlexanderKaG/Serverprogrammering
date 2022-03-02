package se.yrgo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TBL_STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // This line is optional
	private int Id;
	private String enrollmentID;
	private String name;
	private String tutorName; // This will become a class soon
	@Column(name = "NUM_COURSES")
	private Integer numberOfCourses;
	@Transient
	private String email;

	public Student() {

	}

	public Student(String name, String tutorName) {
		this.name = name;
		this.tutorName = tutorName;
	}

	public Student(String name) {
		this.name = name;
		this.tutorName = null;
		this.numberOfCourses = 10;
	}
	
	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getEnrollmentID() {
		return enrollmentID;
	}

	public void setEnrollmentID(String enrollmentID) {
		this.enrollmentID = enrollmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfCourses() {
		return numberOfCourses;
	}

	public void setNumberOfCourses(Integer numberOfCourses) {
		this.numberOfCourses = numberOfCourses;
	}

	public String toString() {
		return String.format("ID: %d, EnrollmentID: %s, Name: %s, Tutor: %s", Id, enrollmentID, name, tutorName);
	}
}
