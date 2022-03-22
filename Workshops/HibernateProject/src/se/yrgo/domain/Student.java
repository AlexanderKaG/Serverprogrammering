package se.yrgo.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.SecondaryTable;
import javax.persistence.Transient;

@Entity
@SecondaryTable(name="ADDRESS")

public class Student extends Person{
	
//	@Column(unique = true, nullable = false)
	private String enrollmentID;
//	@Column(name = "NUM_COURSES")
	private Integer numberOfCourses;
//	@Transient
	private String email;
//	@Embedded
	private Address address;
	
//	private String street;
//	private String city;
//	private String zipcode;

	public Student() {
		super(null);
	}

	public Student(String name, String enrollmentID, String street, String city, String zipcode) {
		super(name);
		this.enrollmentID = enrollmentID;
		this.numberOfCourses = 10;
		this.address = new Address(street, city, zipcode);
//		this.street = street;
//		this.city = city;
//		this.zipcode = zipcode;
	}
	
	public void getReport() {
		System.out.println("Report for student: " + this.getName());
	}

	@Column(unique = true, nullable = false)
	public String getEnrollmentID() {
		return enrollmentID;
	}

	public void setEnrollmentID(String enrollmentID) {
		this.enrollmentID = enrollmentID;
	}

	public String getName() {
		return super.getName();
	}

	public void setName(String name) {
		super.setName(name);
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
		return String.format("ID: %d, Enrollment ID: %s, Name: %s, %s, Number of courses: %d", super.getId(),
				enrollmentID, this.getName(), address.getStreet(), numberOfCourses);
	}

//	@Column (table="ADDRESS")
//	public String getStreet() {
//		return street;
//	}
//
//	public void setStreet(String street) {
//		this.street = street;
//	}
//
//	@Column (table="ADDRESS")
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	@Column (table="ADDRESS")
//	public String getZipcode() {
//		return zipcode;
//	}
//
//	public void setZipcode(String zipcode) {
//		this.zipcode = zipcode;
//	}
}
