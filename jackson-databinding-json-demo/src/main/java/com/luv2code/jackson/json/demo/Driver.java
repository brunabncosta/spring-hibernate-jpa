package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			// creat object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO:
			// data/sample-lite.json
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			System.out.println("First Name = " + student.getFirstName());
			System.out.println("First Name = " + student.getLastName());
			
			//print out address: street and city
			
			Address tempAddress = student.getAddress();
			
			System.out.println("Street = " + tempAddress.getStreet());
			System.out.println("City = " + tempAddress.getCity());
			
			// print out languages
			
			for(String tempLang : student.getLanguages()) {
				System.out.println(tempLang);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
