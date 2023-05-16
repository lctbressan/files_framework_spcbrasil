package com.br.spcbrasil.Pages;

import com.br.spcbrasil.Steps.Hook.BaseStep;
import com.br.spcbrasil.interfaces.DriverFactory;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;

import static org.junit.Assert.assertTrue;

public class HomePage extends BaseStep {

   public static int x = 0;
    public static void thatTheUserIsOnTheHomeScreen(String arg0) throws Exception {
        DriverFactory.getDriver(arg0);
    }


    public static boolean validateXMLSchema(String xsdPath, String xmlPath){

        try {
           // SchemaFactory factory =  SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            SchemaFactory factory =  SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | org.xml.sax.SAXException  e) {
            System.out.println("Erros encontrados : { "+e.getMessage() + " "+ " }");
            return false;
        }
        return true;
    }

    public static void valida(File xml, File xsd) throws Exception{
        Source schemaFile = new StreamSource(xsd);
        Source xmlFile = new StreamSource(xml);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(schemaFile);
        Validator validator = schema.newValidator();
        validator.validate(xmlFile);
    }




    public static void validateXsdDetails(String XSD1,String  XML1) throws Exception {

        StreamSource XSD = new StreamSource(XSD1);
        StreamSource XML = new StreamSource(XML1);

        SchemaFactory factory=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(XSD);

        XMLStreamReader reader = XMLInputFactory.newFactory().createXMLStreamReader(XML);

        Validator validator = schema.newValidator();
        validator.setErrorHandler(new MyErrorHandler(reader));
        validator.validate(new StAXSource(reader));

    }



}
