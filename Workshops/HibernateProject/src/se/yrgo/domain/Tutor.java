package se.yrgo.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tutor {
	private int Id;
	private String tutorId;
	private String name;
	private int salary;
	private Set<Student> teachingGroup;

	public Tutor() {

	}

	public Tutor(String tutorId, String name, int salary) {
		this.tutorId = tutorId;
		this.name = name;
		this.salary = salary;
		this.teachingGroup = new HashSet<Student>();
	}

	public void addStudentToTeachingGroup(Student newStudent) {
		this.teachingGroup.add(newStudent);
	}

	public Set<Student> getTeachingGroup() {
		Set<Student> unmodifiable = Collections.unmodifiableSet(this.teachingGroup);
		return unmodifiable;
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