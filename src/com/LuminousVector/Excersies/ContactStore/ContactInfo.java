package com.LuminousVector.Excersies.ContactStore;

import com.LuminousVector.Utils.Debug;

public class ContactInfo
{
	public String name;
	public String homePhone, businessPhone, cellPhone;
	public String email;
	public String homeAdress, city, state;
	public ContactInfo(String data) throws InvalidContactException
	{
		Debug.log("Input:\n" + data);
		pharseData(data);
	}

	public ContactInfo setName(String name)
	{
		this.name = name;
		return this;
	}

	public ContactInfo setHomePhone(String homePhone)
	{
		this.homePhone = homePhone;
		return this;
	}

	public ContactInfo setBusinessPhone(String businessPhone)
	{
		this.businessPhone = businessPhone;
		return this;
	}

	public ContactInfo setCellPhone(String cellPhone)
	{
		this.cellPhone = cellPhone;
		return this;
	}

	public ContactInfo setEmail(String email)
	{
		this.email = email;
		return this;
	}

	void pharseData(String data) throws InvalidContactException
	{
		try
		{
			String[] dataList = data.split("\\r?\\n");
			name = dataList[0];
			homePhone = dataList[1];
			businessPhone = dataList[2];
			cellPhone = dataList[3];
			email = dataList[4];
			homeAdress = dataList[5];
			city = dataList[6];
			state = dataList[7];
		} catch (Exception e)
		{
			throw new InvalidContactException("Invalid Contact Data");
		}
	}

	public String getData()
	{
		String out = "";
		out += parseValue(name);
		out += parseValue(homePhone);
		out += parseValue(businessPhone);
		out += parseValue(cellPhone);
		out += parseValue(email);
		out += parseValue(homeAdress);
		out += parseValue(city);
		out += parseValue(state);
		return out;
	}

	String parseValue(String value)
	{
		return (value != "null") ? value + "\n" : "null\n";
	}
}
