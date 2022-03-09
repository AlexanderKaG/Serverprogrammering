package se.yrgo.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Student {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO) // This line is optional
	private int Id;
//	@Column(unique = true, nullable = false)
	private String enrollmentID;
	private String name;
//	@Column(name = "NUM_COURSES")
	private Integer numberOfCourses;
//	@Transient
	private String email;
//	@Embedded
	private Address address;

	public Student() {

	}

	public Student(String name, String enrollmentID, String street, String city, String zipcode) {
		this.name = name;
		this.enrollmentID = enrollmentID;
		this.numberOfCourses = 10;
		this.address = new Address(street, city, zipcode);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // This line is optional
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@Column(unique = true, nullable = false)
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

	@Column(name = "NUM_COURSES")
	public Integer getNumberOfCourses() {
		return numberOfCourses;
	}

	public void setNumberOfCourses(Integer numberOfCourses) {
		this.numberOfCourses = numberOfCourses;
	}

	@Transient
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Embedded
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(enrollmentID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(enrollmentID, other.enrollmentID);
	}

	@Override
	public String toString() {
		return String.format("ID: %d, Enrollment ID: %s, Name: %s, Address: %s, Number of courses: %d", Id,
				enrollmentID, name, address, numberOfCourses);
	}
}
