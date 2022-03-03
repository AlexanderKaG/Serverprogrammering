package se.yrgo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@ManyToOne
	@JoinColumn(name = "TUTOR_FK")
	private Tutor tutor; // This will become a class soon
	@Column(name = "NUM_COURSES")
	private Integer numberOfCourses;
	@Transient
	private String email;

	public Student() {

	}

	public Student(String name, Tutor tutor) {
		this.name = name;
		this.tutor = tutor;
	}

	public Student(String name) {
		this.name = name;
		this.tutor = null;
		this.numberOfCourses = 10;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void allocateTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public String getTutorName() {
		return this.tutor.getName();
	}

	public void setTutorName(String name) {
		this.tutor.setName(name);
	}

	@Override
	public String toString() {
		return String.format("ID: %d, Enrollment ID: %s, Name: %s, Tutor: %s, Number of courses: %d", Id, enrollmentID,
				name, tutor, numberOfCourses);
	}
}
