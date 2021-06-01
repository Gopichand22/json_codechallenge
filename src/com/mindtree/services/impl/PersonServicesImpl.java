package com.mindtree.services.impl;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mindtree.dao.PersonDao;
import com.mindtree.dao.impl.PersonDaoImpl;
import com.mindtree.model.Address;
import com.mindtree.model.Pair;
import com.mindtree.model.Person;
import com.mindtree.model.PersonInfo;
import com.mindtree.model.Persons;
import com.mindtree.model.PhoneNumber;
import com.mindtree.services.PersonServices;
import com.mindtree.utils.GenerateXml;
import com.mindtree.utils.RandomNumber;
import com.mindtree.utils.impl.GenerateXmlImpl;
import com.mindtree.utils.impl.RandomNumberImpl;

public class PersonServicesImpl implements PersonServices {

	@Override
	public void parsePersonJsonData(String jsonData) {
		List<Person> personList = new LinkedList<>();
		JsonParser jsonparser = new JsonParser();
		JsonArray jsonArray = (JsonArray) jsonparser.parse(jsonData);
		RandomNumber randomNumber = new RandomNumberImpl();
		for (Object obj : jsonArray) {
			JsonObject person = (JsonObject) obj;
			Person personObj = new Person();
			personObj.setPersonId(randomNumber.generateNumber());
			String firstName = person.get("firstName").toString();
			personObj.setPersonFirstName(firstName);
			String lastName = person.get("lastName").toString();
			personObj.setPersonLastName(lastName);
			String gender = person.get("gender").toString();
			personObj.setPersonGender(gender);
			int age = Integer.parseInt(person.get("age").toString());
			personObj.setPersonAge(age);
			JsonObject address = (JsonObject) person.get("address");
			Address addressObj = new Address();
			addressObj.setAddressId(randomNumber.generateNumber());
			String streetAddress = address.get("streetAddress").toString();
			addressObj.setAddressStreetAddress(streetAddress);
			String city = address.get("city").toString();
			addressObj.setAddressCity(city);
			String state = address.get("state").toString();
			addressObj.setAddressState(state);
			String postalCode = address.get("postalCode").toString();
			addressObj.setAddressPostalCode(postalCode);
			JsonArray phoneNumbers = (JsonArray) person.get("phoneNumbers");
			List<PhoneNumber> phoneNumberList = new LinkedList<>();
			for (Object phnObj : phoneNumbers) {
				JsonObject phoneNumber = (JsonObject) phnObj;
				PhoneNumber phoneNumberObj = new PhoneNumber();
				phoneNumberObj.setPhoneNumberId(randomNumber.generateNumber());
				String type = phoneNumber.get("type").toString();
				phoneNumberObj.setPhoneNumberType(type);
				String number = phoneNumber.get("number").toString();
				phoneNumberObj.setPhoneNumber_Number(number);
				phoneNumberList.add(phoneNumberObj);
			}
			personObj.setPersonAddress(addressObj);
			personObj.setPersonPhoneNumbers(phoneNumberList);
			personList.add(personObj);
		}
		for (int i = 0; i < personList.size(); ++i) {
			Address address = personList.get(i).getPersonAddress();
//			System.out.println(address);
//			PersonDao personDao = new PersonDaoImpl();
//			personDao.createAddress(address);
		}
		for (int i = 0; i < personList.size(); ++i) {
			List<PhoneNumber> phoneNumbers = personList.get(i).getPersonPhoneNumbers();
			for (int j = 0; j < phoneNumbers.size(); ++j) {
				PhoneNumber phoneNumber = phoneNumbers.get(j);
//				System.out.println(phoneNumber);
//				PersonDao personDao = new PersonDaoImpl();
//				personDao.createPhoneNumber(phoneNumber);
			}
		}
		for (Person p : personList) {
			PersonInfo<Integer, String, String, String, Integer> personinfo = new PersonInfo<>();
			personinfo.setpId(p.getPersonId());
			personinfo.setpFname(p.getPersonFirstName());
			personinfo.setpLname(p.getPersonLastName());
			personinfo.setpGender(p.getPersonGender());
			personinfo.setpAge(p.getPersonAge());
//			System.out.println(personinfo);
//			System.out.println(p.getPersonAddress().getAddressId());
//			PersonDao personDao = new PersonDaoImpl();
//			personDao.createPerson(personinfo, p.getPersonAddress().getAddressId());
		}
		for (int i = 0; i < personList.size(); ++i) {
			Pair<Integer, Integer> pair = new Pair<>();
			for (int j = 0; j < personList.get(i).getPersonPhoneNumbers().size(); ++j) {
				pair.setFirst(personList.get(i).getPersonId());
				pair.setSecond(personList.get(i).getPersonPhoneNumbers().get(j).getPhoneNumberId());
//				System.out.println(pair);
//				PersonDao personDao = new PersonDaoImpl();
//				personDao.createmapping(pair);
			}
		}
		PersonDao persondao = new PersonDaoImpl();
		List<Person> personDetails = persondao.getAllDetails();
		for (Person p : personDetails) {
			System.out.println(p);
		}
		Persons persons = new Persons();
		persons.setPersonlist(personDetails);
		GenerateXml generateXml = new GenerateXmlImpl();
		generateXml.displayXml(persons);
	}

}
