package se.yrgo.domain;

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

	public Tutor() {

	}

	public Tutor(String tutorId, String name, int salary) {
		this.tutorId = tutorId;
		this.name = name;
		this.salary = salary;
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
		return "Tutor [Id=" + Id + ", tutorId=" + tutorId + ", name=" + name + ", salary=" + salary + "]";
	}
}