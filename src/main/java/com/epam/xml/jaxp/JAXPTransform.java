package com.epam.xml.jaxp;

import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class JAXPTransform {

    public static void main(String[] args) throws TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Templates template = tf.newTemplates(new StreamSource("src/main/resources/newhello.xsl"));
        Transformer transformer = template.newTransformer();
        transformer.transform(new StreamSource("src/main/resources/hello.xml"), new StreamResult("target/newhello.html"));
        System.out.print("Complete");
    }
}
