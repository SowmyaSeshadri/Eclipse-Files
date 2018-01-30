package com.zilker.signupform;

import com.zilker.signupform.bean.Details;

public class Validation {
	public static boolean validateParameters(Details details) {
		String names ="^[A-Za-z]+$";
		String phoneNumber = "^[0-9]{10}";
		String emailVal = "[a-zA-Z]\\w+@[a-z]+\\.[a-zA-Z.-]+";
		
		String firstName = details.getFirstName();
		String lastName = details.getLastName();
		String email = details.getEmail();
		String phone = details.getPhone();
		String userName = details.getUername();
		
		
		if(!firstName.matches(names) || !lastName.matches(names) || !email.matches(emailVal) || !phone.matches(phoneNumber))
			return false;
		else
			return true;
		
	}
}
