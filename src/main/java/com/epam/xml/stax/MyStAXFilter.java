package com.epam.xml.stax;

import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLStreamReader;

class MyStAXFilter implements StreamFilter {

    public boolean accept(XMLStreamReader reader) {
        return reader.isStartElement() || reader.isEndElement();
    }
}
