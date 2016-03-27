package com.epam.xml.dom;

import com.epam.xml.sax.Food;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMMenuParser {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File("src/main/resources/breakfastmenu.xml"));

        Element root = document.getDocumentElement();

        List<Food> menu = new ArrayList<>();

        NodeList foodNodes = root.getElementsByTagName("food");

        for (int i = 0; i < foodNodes.getLength(); i++) {
            Element foodElement = (Element) foodNodes.item(i);
            Food food = getFood(foodElement);
            menu.add(food);
        }

        for (Food f : menu) {
            System.out.println(f);
        }
    }

    private static Food getFood(Element foodElement) {
        Food food = new Food();
        food.setId(Integer.parseInt(foodElement.getAttribute("id")));
        food.setName(getSingleChild(foodElement, "name").getTextContent().trim());
        food.setDescription(getSingleChild(foodElement, "description").getTextContent().trim());
        food.setPrice(getSingleChild(foodElement, "price").getTextContent().trim());
        food.setCalories(Integer.parseInt(getSingleChild(foodElement, "calories").getTextContent().trim()));
        return food;
    }

    private static Element getSingleChild(Element element, String childName) {
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }
}
