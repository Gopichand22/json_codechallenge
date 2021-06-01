package com.mindtree.dao;

import com.mindtree.model.*;
import java.util.List;

public interface PersonDao {
	void createAddress(Address address);

	void createPhoneNumber(PhoneNumber phoneNumber);

	void createPerson(PersonInfo<Integer, String, String, String, Integer> personinfo, int addressId);

	void createmapping(Pair<Integer, Integer> pair);

	List<Person> getAllDetails();
}
