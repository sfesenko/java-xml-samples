package com.epam.xml.validation;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XSDValidation {

    public static void main(String[] args) throws SAXException, IOException {
        // 1.
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        // 2.
        File schemaLocation = new File("src/main/resources/notes.xsd");
        Schema schema = factory.newSchema(schemaLocation);

        // 3.
        Validator validator = schema.newValidator();
        // 4.
        Source source = new StreamSource("src/main/resources/notes.xml");
        // 5.
        try {
            validator.validate(source);
            System.out.println(" is valid.");
        } catch (SAXException ex) {
            System.out.println(" is not valid because " + ex.getMessage());
        }

    }
}
