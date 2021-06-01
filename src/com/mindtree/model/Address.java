package com.mindtree.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
public class Address {
	private int addressId;
	private String addressStreetAddress;
	private String addressCity;
	private String addressState;
	private String addressPostalCode;

	public Address() {
		super();
	}

	public Address(int addressId, String addressStreetAddress, String addressCity, String addressState,
			String addressPostalCode) {
		super();
		this.addressId = addressId;
		this.addressStreetAddress = addressStreetAddress;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressPostalCode = addressPostalCode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@XmlElement(name = "street_address")
	public String getAddressStreetAddress() {
		return addressStreetAddress;
	}

	public void setAddressStreetAddress(String addressStreetAddress) {
		this.addressStreetAddress = addressStreetAddress;
	}

	@XmlElement(name = "city")
	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	@XmlElement(name = "state")
	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	@XmlElement(name = "postal_code")
	public String getAddressPostalCode() {
		return addressPostalCode;
	}

	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressStreetAddress=" + addressStreetAddress + ", addressCity="
				+ addressCity + ", addressState=" + addressState + ", addressPostalCode=" + addressPostalCode + "]";
	}

}
