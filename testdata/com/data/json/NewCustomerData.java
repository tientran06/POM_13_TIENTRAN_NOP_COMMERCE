package com.data.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NewCustomerData {
	
	public static NewCustomerData getNewCustomer(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(new File(filename), NewCustomerData.class);
	}

	@JsonProperty("firstname")
	String firstname;
	
	@JsonProperty("lastname")
	String lastname;
	
	@JsonProperty("day")
	String day;
	
	@JsonProperty("month")
	String month;
	
	@JsonProperty("year")
	String year;
	
	@JsonProperty("email")
	String email;
	
	@JsonProperty("company")
	String company;
	
	@JsonProperty("password")
	String password;

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public String getEmail() {
		return email;
	}

	public String getCompany() {
		return company;
	}

	public String getPassword() {
		return password;
	}
}
