package com.epam.xml.sax;

import java.util.ArrayList;
import java.util.List;

import com.epam.xml.sax.Food;
import com.epam.xml.sax.MenuTagName;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MenuSaxHandler extends DefaultHandler {
    private List<Food> foodList = new ArrayList<>();
    private Food food;
    private StringBuilder text;

    public List<Food> getFoodList() {
        return foodList;
    }

    public void startDocument() throws SAXException {
        System.out.println("Parsing started.");
    }

    public void endDocument() throws SAXException {
        System.out.println("Parsing ended.");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.printf("startElement -> uri: %s, localName: %s, qName: %s%n", uri, localName, qName);

        text = new StringBuilder();
        if (qName.equals("food")) {
            food = new Food();
            food.setId((Integer.parseInt(attributes.getValue("id"))));
        }
    }

    public void characters(char[] buffer, int start, int length) {
        System.out.printf("characters -> start: %d, length: %d, value: %s\n", start, length, new String(buffer, start, length));
        text.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        MenuTagName tagName = MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (tagName) {
            case NAME:
                food.setName(text.toString());
                break;
            case PRICE:
                food.setPrice(text.toString());
                break;
            case DESCRIPTION:
                food.setDescription(text.toString());
                break;
            case CALORIES:
                food.setCalories(Integer.parseInt(text.toString()));
                break;
            case FOOD:
                foodList.add(food);
                food = null;
                break;
        }
    }

    public void warning(SAXParseException exception) {
        System.err.printf("WARNING: line %d: %s%n", exception.getLineNumber(), exception.getMessage());
    }

    public void error(SAXParseException exception) {
        System.err.printf("ERROR: line %d: %s%n", exception.getLineNumber(), exception.getMessage());
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.printf("FATAL: line %d: %s%n", exception.getLineNumber(), exception.getMessage());
        throw (exception);
    }
}
