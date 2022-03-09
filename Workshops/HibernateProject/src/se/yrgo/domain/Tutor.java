package se.yrgo.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Tutor {

	private int Id;
	private String tutorId;
	private String name;
	private int salary;
	private Set<Student> teachingGroup;
	private Set<Subject> subjectsToTeach;

	public Tutor() {

	}

	public Tutor(String tutorId, String name, int salary) {

		this.tutorId = tutorId;
		this.name = name;
		this.salary = salary;
		this.teachingGroup = new HashSet<Student>();
		this.subjectsToTeach = new HashSet<Subject>();
	}

	public void createStudentAndAddtoTeachingGroup(String studentName, String enrollmentID, String street, String city,
			String zipcode) {
		Student student = new Student(studentName, enrollmentID, street, city, zipcode);
		this.addStudentToTeachingGroup(student);
	}

	public void addSubjectsToTeach(Subject subject) {
		this.subjectsToTeach.add(subject);
		subject.getTutors().add(this);
	}

	public void addStudentToTeachingGroup(Student newStudent) {
		this.teachingGroup.add(newStudent);
	}

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "TUTOR_FK")
	public Set<Student> getTeachingGroup() {
		Set<Student> unmodifiable = Collections.unmodifiableSet(this.teachingGroup);
		return unmodifiable;
	}

	public void setTeachingGroup(Set<Student> teachingGroup) {
		this.teachingGroup = teachingGroup;
	}

	@ManyToMany(mappedBy = "tutors")
	public Set<Subject> getSubjectsToTeach() {
		return subjectsToTeach;
	}

	public void setSubjectsToTeach(Set<Subject> subjectsToTeach) {
		this.subjectsToTeach = subjectsToTeach;
	}

	@Transient
	public Set<Subject> getSubjects() {
		return this.subjectsToTeach;
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