package com.br.spcbrasil.Steps;

import com.br.spcbrasil.Pages.HomePage;
import com.br.spcbrasil.Steps.Hook.BaseStep;
import com.br.spcbrasil.Utils.Config;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import org.apache.commons.io.FileUtils;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static com.br.spcbrasil.Pages.MyErrorHandler.logwritter;
import static com.br.spcbrasil.Utils.Config.PathOrigin;
import static com.br.spcbrasil.Utils.Config.pSit;


public class HomeSteps extends BaseStep {


    Config cons = new Config();





    @Given("^that the user is on the home screen \"([^\"]*)\"$")
    public void thatTheUserIsOnTheHomeScreen(String Env) throws Exception {
        Config.prmCardCoout = 0;
        Config.prmListCount = 0;
        Config.prmPagination = 0;

    }

    @And("Click Login")
    public void clickLogin() {
    }

    @And("Enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterAnd(String arg0, String arg1) {
    }

    @And("Select Project Trendalitycs")
    public void selectProjectTrendalitycs() {
    }

    @And("Click StopStart")
    public void clickStopStart() {
    }




    @Given("^valida o xml conta o xsd \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void validaOXmlContaOXsd( String patxsd, String xsdName, String folderXml, String Sit) throws Exception {
        String xsd = patxsd  + xsdName;
        //Lista o diretorio
        File folder = new File(folderXml);
        listFDirectoriesStream(folderXml.toString(),Sit,xsd);

    }

    public static void listFDirectoriesStream(String dir,String Sit,String xsd) throws Exception {
        PathOrigin =dir.toString();
        pSit = Sit;
        String ArqXml =  "";
        String prmRunner = "";
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    System.out.println("VALIDANDO ARQUIVO  " + path.getFileName().toString());
                    logwritter("VALIDANDO ARQUIVO  " + path.getFileName().toString());

                    ArqXml = path.getFileName().toString();

                    // findAllFilesInFolder(new File(path.toString()),prmRunner,Sit);
                   // validateFile(xsd,path.toString());
                    HomePage.validateXsdDetails(xsd,path.toString());
                }
            }
        }
        //return Dirs;
    }

    public static void validateFile(String xsd,String xml) throws Exception {
        HomePage.validateXMLSchema(xsd,xml);


        //HomePage.valida(new File(xml), new File(xsd));
    }

    public static void findAllFilesInFolder(File folder,String Runner,String Sit) throws Exception {
        try{
            String path = folder.toString();
            String fileName ="";
            if (Sit.equals("Validate")) {
                for (File file : Objects.requireNonNull(folder.listFiles())) {
                    if (!file.isDirectory()) {
                        fileName = file.getName();
                        if (fileName.contains("xml")) {

                            File destinationFile = null;
                            File sourceFile = new File(folder + "\\" + file.getName());


                                HomePage.validateXMLSchema("","");

                                System.out.println("EXISTS >>> " + destinationFile);
      }
                    }
                }
            }


        } catch (Exception e) {
            //listFDirectoriesStream(PathOrigin,pSit);
        }
    }


    @Given("that i remove all folders from path \"([^\"]*)\"$")
    public void thatIremovePathsRespond(String path) throws Exception {
        File folder = new File(path);
        //removeDirectoriesStream(path.toString());
        deleteDirectoryRecursionJava6(new File(path.toString()));
    }




    public static void removeDirectoriesStream(String dir) throws Exception {
        PathOrigin =dir.toString();

        String Dirs =  "";
        String prmRunner = "";
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {

                    Dirs = path.getFileName().toString() +";"+ Dirs;
                    prmRunner =path.getFileName().toString();


                    //FileUtils.deleteDirectory(new File(path.toString()));
                    deleteDirectoryRecursionJava6(new File(path.toString()));
                }
            }
        }
        //return Dirs;
    }
    public static void deleteDirectoryRecursionJava6(File file) throws IOException {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteDirectoryRecursionJava6(entry);
                    System.out.println("REMOVING :" + entry);
                }
            }
        }
        if (!file.delete()) {
            throw new IOException("Failed to delete " + file);
        }
    }






    private static String readFromInputStream(InputStream inputstream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputstream))) {
            String line;
            while ((line = br.readLine()) != "") {
                resultStringBuilder.append(line).append("\n");
            }
            return resultStringBuilder.toString();

        }
    }


    private static void WriteToFile(String Path, String Runner,String Data) throws IOException {
        try {
        FileWriter myWriter = new FileWriter(Path+"\\"+Runner+".html");
            System.out.println("Gravando....");
            System.out.println(Path+"\\"+Runner+".html");
            System.out.println(Data);
        myWriter.write(Data);
        myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    public static boolean validateXMLSchema(String xsdPath, String xmlPath){

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | org.xml.sax.SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }

    @After
    public void teardownSteps() throws Exception {

    }



}
