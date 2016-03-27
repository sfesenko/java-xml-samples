package com.epam.xml.stax;

import com.epam.xml.sax.Food;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXMenuParser {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream input = new FileInputStream("src/main/resources/breakfastmenu.xml");

        XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
        List<Food> menu = process(reader);

        for (Food food : menu) {
            System.out.println(food);
        }
    }

    private static List<Food> process(XMLStreamReader reader) throws XMLStreamException {
        List<Food> menu = new ArrayList<>();
        Food food = null;
        MenuTagName elementName = null;
        while (reader.hasNext()) {
            // ����������� ���� "����������" �������� (����)
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = MenuTagName.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case FOOD:
                            food = new Food();
                            int id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                            food.setId(id);
                            break;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();

                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case NAME:
                            food.setName(text);
                            break;
                        case PRICE:
                            food.setPrice(text);
                            break;
                        case DESCRIPTION:
                            food.setDescription(text);
                            break;
                        case CALORIES:
                            Integer calories = Integer.parseInt(text);
                            food.setCalories(calories);
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    elementName = MenuTagName.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case FOOD:
                            menu.add(food);
                    }
            }
        }
        return menu;
    }
}
