package se.yrgo.domain;

public abstract class Person {
	private int Id;
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public void getReport() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
