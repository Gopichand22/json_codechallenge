package com.mindtree.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class Person {
	private int personId;
	private String personFirstName;
	private String personLastName;
	private String personGender;
	private int personAge;
	private Address personAddress;
	private List<PhoneNumber> personPhoneNumbers;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int personId, String personFirstName, String personLastName, String personGender, int personAge,
			Address personAddress, List<PhoneNumber> personPhoneNumbers) {
		super();
		this.personId = personId;
		this.personFirstName = personFirstName;
		this.personLastName = personLastName;
		this.personGender = personGender;
		this.personAge = personAge;
		this.personAddress = personAddress;
		this.personPhoneNumbers = personPhoneNumbers;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	@XmlElement(name = "fname")
	public String getPersonFirstName() {
		return personFirstName;
	}

	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}

	@XmlElement(name = "lname")
	public String getPersonLastName() {
		return personLastName;
	}

	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}

	@XmlElement(name = "gender")
	public String getPersonGender() {
		return personGender;
	}

	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}

	@XmlElement(name = "age")
	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	@XmlElement(name = "address")
	public Address getPersonAddress() {
		return personAddress;
	}

	public void setPersonAddress(Address personAddress) {
		this.personAddress = personAddress;
	}

	@XmlElement(name = "phone_numbers")
	public List<PhoneNumber> getPersonPhoneNumbers() {
		return personPhoneNumbers;
	}

	public void setPersonPhoneNumbers(List<PhoneNumber> personPhoneNumbers) {
		this.personPhoneNumbers = personPhoneNumbers;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personFirstName=" + personFirstName + ", personLastName="
				+ personLastName + ", personGender=" + personGender + ", personAge=" + personAge + ", personAddress="
				+ personAddress + ", personPhoneNumbers=" + personPhoneNumbers + "]";
	}

}
