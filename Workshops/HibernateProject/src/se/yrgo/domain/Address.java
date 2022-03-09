package se.yrgo.domain;

public class Address {

	private String street;
	private String city;
	private String zipcode;

	public Address() {

	}

	public Address(String street, String city, String zipcode) {
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String toString() {
		return String.format("Street: %s, City: %d, Zipcode: d%", street, city, zipcode);
	}
}
