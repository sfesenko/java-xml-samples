package com.epam.xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class FoodJAXBUnMarshaller {

	public static void main(String[] args) throws JAXBException {
		File file = new File("src/main/resources/stud.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Food.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Food food = (Food) jaxbUnmarshaller.unmarshal(file);
		System.out.println(food.getName());
	}
}
