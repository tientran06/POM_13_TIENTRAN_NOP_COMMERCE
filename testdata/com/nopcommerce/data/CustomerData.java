package com.nopcommerce.data;

import commons.DataHelperFacker;

public class CustomerData {
	
	public static class NewCustomer {
		public static final String FIRSTNAME = DataHelperFacker.getData().getFirstName();
		public static final String LASTNAME = DataHelperFacker.getData().getLastName();
		
		public static final String DAY = "2";
		public static final String MONTH = "June";
		public static final String YEAR = "1987";
		
		public static final String EMAIL = DataHelperFacker.getData().getEmail();
		public static final String COMPANYNAME = DataHelperFacker.getData().getCompanyName();
		public static final String PASSWORD = DataHelperFacker.getData().getPassword();

	}
	
	public static class EditCustomer {

	}
}
