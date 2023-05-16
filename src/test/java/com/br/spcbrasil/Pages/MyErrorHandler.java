package com.br.spcbrasil.Pages;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.io.File;

public class MyErrorHandler implements ErrorHandler {

    private XMLStreamReader reader;

    public MyErrorHandler(XMLStreamReader reader) {
        this.reader = reader;
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        warning(e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        warning(e);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String stacktrace = ExceptionUtils.getStackTrace(e);
        System.out.println(reader.getLocalName());
        System.out.println(reader.getNamespaceURI());
        e.printStackTrace(System.out);
        e.getColumnNumber();
        e.getLineNumber();

        logwritter(reader.getLocalName() +"\n"+reader.getNamespaceURI()
                +"\n Column number : "+  e.getColumnNumber()
                +"\n Line Number : "+ e.getLineNumber()
                +" \n GetName : "+ reader.getName()
                        +" \n XSD Validaton : "+ e.getLocalizedMessage()
               // +" \n GetText : "+ reader.getText().toString()
        );

        logwritter("====================================================================================================================================s==================================EOF");


    }

public static void logwritter(String content){
    try {


/*

        File file = new  File("C:\\spcbrasil\\log\\validation_log.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
*/
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\spcbrasil\\log\\validation_log.txt", true)));

            out.println(content);
            out.close();


    } catch (IOException e) {
        e.printStackTrace();
    }
}


}
