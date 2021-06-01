package com.mindtree.model;

public class PersonInfo<T1, T2, T3, T4, T5> {
	private T1 pId;
	private T2 pFname;
	private T3 pLname;
	private T4 pGender;
	private T5 pAge;

	public PersonInfo() {
		super();
	}

	public PersonInfo(T1 pId, T2 pFname, T3 pLname, T4 pGender, T5 pAge) {
		super();
		this.pId = pId;
		this.pFname = pFname;
		this.pLname = pLname;
		this.pGender = pGender;
		this.pAge = pAge;
	}

	public T1 getpId() {
		return pId;
	}

	public void setpId(T1 pId) {
		this.pId = pId;
	}

	public T2 getpFname() {
		return pFname;
	}

	public void setpFname(T2 pFname) {
		this.pFname = pFname;
	}

	public T3 getpLname() {
		return pLname;
	}

	public void setpLname(T3 pLname) {
		this.pLname = pLname;
	}

	public T4 getpGender() {
		return pGender;
	}

	public void setpGender(T4 pGender) {
		this.pGender = pGender;
	}

	public T5 getpAge() {
		return pAge;
	}

	public void setpAge(T5 pAge) {
		this.pAge = pAge;
	}

	@Override
	public String toString() {
		return "PersonInfo [pId=" + pId + ", pFname=" + pFname + ", pLname=" + pLname + ", pGender=" + pGender
				+ ", pAge=" + pAge + "]";
	}

}
