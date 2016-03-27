package com.epam.xml.jaxp;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class TrAXExample {

	public static void main(String[] args) throws TransformerException {
		Source domSource = new DOMSource();
		Result fileResult = new StreamResult(new File("src/main/resources/menu.xml"));
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.transform(domSource, fileResult);

		//Node node = domSource.ge
	}

}
