package com.mindtree.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.mindtree.dao.PersonDao;
import com.mindtree.model.Address;
import com.mindtree.model.Pair;
import com.mindtree.model.Person;
import com.mindtree.model.PersonInfo;
import com.mindtree.model.PhoneNumber;
import com.mindtree.utils.DbUtils;
import com.mindtree.utils.impl.DbUtilsImpl;

public class PersonDaoImpl implements PersonDao {

	@Override
	public void createAddress(Address address) {
		DbUtils dbutil = new DbUtilsImpl();
		Connection con = null;
		PreparedStatement ps = null;
		final String INSERT_ADDRESS = "INSERT INTO `practicedb`.`address` (`address_id`, `street_address`, `city`, `state`, `postal_code`) VALUES (?, ?, ?, ?, ?)";
		try {
			con = dbutil.makeConnection(con);
			ps = con.prepareStatement(INSERT_ADDRESS);
			ps.setInt(1, address.getAddressId());
			ps.setString(2, address.getAddressStreetAddress());
			ps.setString(3, address.getAddressCity());
			ps.setString(4, address.getAddressState());
			ps.setString(5, address.getAddressPostalCode());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void createPhoneNumber(PhoneNumber phoneNumber) {
		DbUtils dbutil = new DbUtilsImpl();
		Connection con = null;
		PreparedStatement ps = null;
		final String INSERT_PHONE_NUMBER = "INSERT INTO `practicedb`.`phone_numbers` (`ph_id`, `ph_type`, `ph_number`) VALUES (?, ?, ?)";
		try {
			con = dbutil.makeConnection(con);
			ps = con.prepareStatement(INSERT_PHONE_NUMBER);
			ps.setInt(1, phoneNumber.getPhoneNumberId());
			ps.setString(2, phoneNumber.getPhoneNumberType());
			ps.setString(3, phoneNumber.getPhoneNumber_Number());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void createPerson(PersonInfo<Integer, String, String, String, Integer> personinfo, int addressId) {
		DbUtils dbutil = new DbUtilsImpl();
		Connection con = null;
		PreparedStatement ps = null;
		final String INSERT_PERSON = "INSERT INTO `practicedb`.`persons` (`person_id`, `person_fname`, `person_lname`, `person_gender`, `person_age`, `address_id`) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			con = dbutil.makeConnection(con);
			ps = con.prepareStatement(INSERT_PERSON);
			ps.setInt(1, personinfo.getpId());
			ps.setString(2, personinfo.getpFname());
			ps.setString(3, personinfo.getpLname());
			ps.setString(4, personinfo.getpGender());
			ps.setInt(5, personinfo.getpAge());
			ps.setInt(6, addressId);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void createmapping(Pair<Integer, Integer> pair) {
		DbUtils dbutil = new DbUtilsImpl();
		Connection con = null;
		PreparedStatement ps = null;
		final String INSERT_MAPPING = "INSERT INTO `practicedb`.`map` (`ph_id`, `person_id`) VALUES (?, ?)";
		try {
			con = dbutil.makeConnection(con);
			ps = con.prepareStatement(INSERT_MAPPING);
			ps.setInt(1, pair.getSecond());
			ps.setInt(2, pair.getFirst());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public List<Person> getAllDetails() {
		List<Person> personList = new LinkedList<>();
		DbUtils dbutil = new DbUtilsImpl();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		final String FROM_PERSON = "SELECT person_id, person_fname, person_lname, person_gender, person_age, address_id FROM persons";
		try {
			con = dbutil.makeConnection(con);
			ps = con.prepareStatement(FROM_PERSON);
			rs = ps.executeQuery();
			while (rs.next()) {
				Person person = new Person();
				person.setPersonId(rs.getInt("person_id"));
				person.setPersonFirstName(rs.getString("person_fname"));
				person.setPersonLastName(rs.getString("person_lname"));
				person.setPersonGender(rs.getString("person_gender"));
				person.setPersonAge(rs.getInt("person_age"));
				person.setPersonAddress(getAddressObject(rs.getInt("address_id")));
				person.setPersonPhoneNumbers(getThatList(person.getPersonId()));
				personList.add(person);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return personList;
	}

	private List<PhoneNumber> getThatList(int personId) {
		List<PhoneNumber> phoneNumbers = new LinkedList<>();
		DbUtils dbutils = new DbUtilsImpl();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		final String FROM_MAP = "SELECT ph_id FROM map WHERE person_id=?";
		try {
			con = dbutils.makeConnection(con);
			ps = con.prepareStatement(FROM_MAP);
			ps.setInt(1, personId);
			rs = ps.executeQuery();
			while (rs.next()) {
				phoneNumbers.add(getPhoneObject(rs.getInt("ph_id")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return phoneNumbers;
	}

	private PhoneNumber getPhoneObject(int phoneId) {
		DbUtils dbutils = new DbUtilsImpl();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		final String FROM_PHONE_NUMBERS = "SELECT ph_id, ph_type, ph_number FROM phone_numbers WHERE ph_id=?";
		PhoneNumber phoneNumber = new PhoneNumber();
		try {
			con = dbutils.makeConnection(con);
			ps = con.prepareStatement(FROM_PHONE_NUMBERS);
			ps.setInt(1, phoneId);
			rs = ps.executeQuery();
			while (rs.next()) {
				phoneNumber.setPhoneNumberId(rs.getInt("ph_id"));
				phoneNumber.setPhoneNumberType(rs.getString("ph_type"));
				phoneNumber.setPhoneNumber_Number(rs.getString("ph_number"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return phoneNumber;
	}

	private Address getAddressObject(int addressId) {
		DbUtils dbutil = new DbUtilsImpl();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		final String FROM_ADDRESS = "SELECT address_id, street_address, city, state, postal_code FROM address WHERE address_id=?";
		Address address = new Address();
		try {
			con = dbutil.makeConnection(con);
			ps = con.prepareStatement(FROM_ADDRESS);
			ps.setInt(1, addressId);
			rs = ps.executeQuery();
			while (rs.next()) {
				address.setAddressId(rs.getInt("address_id"));
				address.setAddressStreetAddress(rs.getString("street_address"));
				address.setAddressCity(rs.getString("city"));
				address.setAddressState(rs.getString("state"));
				address.setAddressPostalCode(rs.getString("postal_code"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return address;
	}

}
