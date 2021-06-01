package com.mindtree.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "persons")
public class Persons {
	private List<Person> personlist;

	public Persons() {
		super();
	}

	public Persons(List<Person> personlist) {
		super();
		this.personlist = personlist;
	}

	@XmlElement(name = "person")
	public List<Person> getPersonlist() {
		return personlist;
	}

	public void setPersonlist(List<Person> personlist) {
		this.personlist = personlist;
	}

	@Override
	public String toString() {
		return "Persons [personlist=" + personlist + "]";
	}
}
