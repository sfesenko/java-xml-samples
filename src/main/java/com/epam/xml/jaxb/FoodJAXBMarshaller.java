package com.epam.xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FoodJAXBMarshaller {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(Food.class);
		Marshaller m = context.createMarshaller();
		
		Food food = new Food();
		food.setId(123);
		food.setName("Name Of Food");
		food.setDescription("Description of food");
		food.setCalories(234);
		food.setPrice("333");
		
		m.marshal(food, new FileOutputStream("src/main/resources/stud.xml"));
		m.marshal(food, System.out);
		System.out.println("\nDone");
	}
}
