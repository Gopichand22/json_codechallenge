package com.mindtree.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "phone_number")
public class PhoneNumber {
	private int phoneNumberId;
	private String phoneNumberType;
	private String phoneNumber_Number;

	public PhoneNumber() {
		super();
	}

	public PhoneNumber(int phoneNumberId, String phoneNumberType, String phoneNumber_Number) {
		super();
		this.phoneNumberId = phoneNumberId;
		this.phoneNumberType = phoneNumberType;
		this.phoneNumber_Number = phoneNumber_Number;
	}

	public int getPhoneNumberId() {
		return phoneNumberId;
	}

	public void setPhoneNumberId(int phoneNumberId) {
		this.phoneNumberId = phoneNumberId;
	}

	@XmlElement(name = "type")
	public String getPhoneNumberType() {
		return phoneNumberType;
	}

	public void setPhoneNumberType(String phoneNumberType) {
		this.phoneNumberType = phoneNumberType;
	}

	@XmlElement(name = "number")
	public String getPhoneNumber_Number() {
		return phoneNumber_Number;
	}

	public void setPhoneNumber_Number(String phoneNumber_Number) {
		this.phoneNumber_Number = phoneNumber_Number;
	}

	@Override
	public String toString() {
		return "PhoneNumber [phoneNumberId=" + phoneNumberId + ", phoneNumberType=" + phoneNumberType
				+ ", phoneNumber_Number=" + phoneNumber_Number + "]";
	}

}
