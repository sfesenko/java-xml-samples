package com.epam.xml.stax;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StAXWriterExample {

    public static void main(String[] args) throws XMLStreamException, IOException {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("target/output2.xml"));

        writer.writeStartDocument();
        writer.writeStartElement("document");
        writer.writeStartElement("data");
        writer.writeAttribute("name", "value");
        writer.writeCharacters("content");
        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();

        writer.flush();
        writer.close();
    }
}
