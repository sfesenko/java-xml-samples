package com.epam.xml.sax.filter;


import com.epam.xml.sax.MenuSaxHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SAXFilterDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		NamespaceFilter namespaceFilter = new NamespaceFilter(reader);
		ElementFilter elementFilter = new ElementFilter();
		elementFilter.setParent(namespaceFilter);
	    MenuSaxHandler handler = new MenuSaxHandler();
	    elementFilter.setContentHandler(handler);
	    elementFilter.parse(new InputSource("src/main/resources/menu.xml"));
	}
}
