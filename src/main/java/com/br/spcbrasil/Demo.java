package com.br.spcbrasil;

import javax.xml.XMLConstants;
import javax.xml.stream.*;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

public class Demo {

    private static final StreamSource XSD = new StreamSource("C:\\spcbrasil\\xsd\\ACPO111.xsd");
    private static final StreamSource XML = new StreamSource("C:\\spcbrasil\\Arquivos\\ACPO111_15930421_34173682_20230303_00001.xml");

    public static void main(String[] args) throws Exception {
        SchemaFactory factory=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(XSD);

        XMLStreamReader reader = XMLInputFactory.newFactory().createXMLStreamReader(XML);

        Validator validator = schema.newValidator();
        validator.setErrorHandler(new MyErrorHandler2(reader));
        validator.validate(new StAXSource(reader));

    }

}