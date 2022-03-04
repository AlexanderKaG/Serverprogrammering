package se.yrgo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {

	private int Id;
	private String subjectName;
	private int numberOfSemesters;
	private Set<Tutor> tutors;

	public Subject() {

	}

	public Subject(String subjectName, int numberOfSemesters) {
		this.subjectName = subjectName;
		this.numberOfSemesters = numberOfSemesters;
		this.tutors = new HashSet<Tutor>();
	}

	public void addTutorToSubject(Tutor tutor) {
		this.tutors.add(tutor);
		tutor.getSubjects().add(this);
	}

	@ManyToMany
	public Set<Tutor> getTutors() {
		return tutors;
	}

	public void setTutors(Set<Tutor> tutors) {
		this.tutors = tutors;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // This line is optional
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getNumberOfSemesters() {
		return numberOfSemesters;
	}

	public void setNumberOfSemesters(int numberOfSemesters) {
		this.numberOfSemesters = numberOfSemesters;
	}

}
