package se.yrgo.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Tutor {
	private int Id;
	private String tutorId;
	private String name;
	private int salary;
	private Map<String, Student> teachingGroup;

	public Tutor() {

	}

	public Tutor(String tutorId, String name, int salary) {
		this.tutorId = tutorId;
		this.name = name;
		this.salary = salary;
		this.teachingGroup = new HashMap<String, Student>();
	}

	public void addStudentToTeachingGroup(Student newStudent) {
		this.teachingGroup.put(newStudent.getEnrollmentID(), newStudent);
	}

	@OneToMany
	@MapKey(name = "enrollmentID")
	public Map<String, Student> getTeachingGroup() {
		Map<String, Student> unmodifiable = Collections.unmodifiableMap(this.teachingGroup);
		return unmodifiable;
	}

	public void setTeachingGroup(Map<String, Student> teachingGroup) {
		this.teachingGroup = teachingGroup;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // This line is optional
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTutorId() {
		return tutorId;
	}

	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.format("ID: %d, Tutor ID: %s, Name: %s, Salary: %d", Id, tutorId, name, salary);
	}
}