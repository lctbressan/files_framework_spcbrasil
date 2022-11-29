package com.braziltest.Steps;

import com.braziltest.Pages.HomePage;
import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Utils.Config;
import com.braziltest.Utils.Instrumentation;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static com.braziltest.Utils.Config.PathOrigin;
import static com.braziltest.Utils.Config.pSit;
import static com.braziltest.utils.ProcessBuilderRun.processCommand;

public class HomeSteps extends BaseStep {


    Config cons = new Config();




    @Then("^I get the message Home \"([^\"]*)\"$")
    public void IgetthemessageHome(String arg1) throws Throwable {
        HomePage.GetMessageHome(arg1);
    }

    @And("confirm action Home")
    public void confirmActionHome() throws IOException {
        HomePage.confirmActionHome();
    }


    @When("^click on menu \"([^\"]*)\" link")
    public void clickOnProductLink(String arg0) throws Exception {
        HomePage.clickOnProductLink(arg0);

    }

    @And("accept cookies")
    public void acceptCookies() throws IOException {
        HomePage.acceptCookies();
    }

    @Given("^that the user is on the home screen \"([^\"]*)\"$")
    public void thatTheUserIsOnTheHomeScreen(String Env) throws Exception {
    String arg0 = "";
        if(Env.equals("ciq")){
            arg0= "https://staging-ciq.almaden.dev/";
        }
        if(Env.equals("smc")){
            arg0= "https://homologsmart.automatos.com/auth/signin/";

        }

        HomePage.thatTheUserIsOnTheHomeScreen(arg0);
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

    @And("abre a conexao nao particular")
    public void abreAConexaoNaoParticular() throws IOException {
        HomePage.abreaconexaoNaoparticular();
    }

    @And("ir para \"([^\"]*)\" e \"([^\"]*)\"$")
    public void irParaE(String arg0, String arg1) throws IOException {
        HomePage.irPara(arg0,arg1);
    }

    @And("Send login \"([^\"]*)\" and \"([^\"]*)\"$")
    public void sendLoginAnd(String arg0, String arg1) throws IOException, InterruptedException {
        HomePage.sendLoginandPass(arg0,arg1);
    }

    @And("Reinicia o roteador")
    public void reiniciaORoteador() throws Exception {
        HomePage.reiniciaoteador();
    }

    @Given("that i copy all files from path \"([^\"]*)\" \"([^\"]*)\"$")
    public void thatICheckPathsRespond(String path,String Sit) throws Exception {
        //Lista o diretorio
        File folder = new File(path);

        listFDirectoriesStream(path.toString(),Sit);
        /*for(String item : arq.split(";")){
            findAllFilesInFolder(new File(path + item));
        }*/
    }



    public static void listFDirectoriesStream(String dir,String Sit) throws Exception {
        PathOrigin =dir.toString();
        pSit = Sit;
        String Dirs =  "";
        String prmRunner = "";
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    //fileList.add(path.getFileName().toString());
                    //System.out.println("LENDO DIR " + path.getFileName().toString());
                    Dirs = path.getFileName().toString() +";"+ Dirs;
                    prmRunner =path.getFileName().toString();
                    findAllFilesInFolder(new File(path.toString()),prmRunner,Sit);
                }
            }
        }
        //return Dirs;
    }
    public static void findAllFilesInFolder(File folder,String Runner,String Sit) throws Exception {
        try{
            String path = folder.toString();
            String fileName ="";
            if (Sit.equals("Copy")) {
                for (File file : Objects.requireNonNull(folder.listFiles())) {
                    if (!file.isDirectory()) {
                        fileName = file.getName();
                        if (fileName.contains("html") || fileName.contains("avi")) {
                            //System.out.println(file.getName());
                            //CHAMA A ROTINA DE TRATAMENTO DO ARQUIVO
                            //saveEvidence(path+"\\",file.getName(),Runner);
                            File destinationFile = null;
                            File sourceFile = new File(folder + "\\" + file.getName());
                            if (fileName.contains("avi")) {
                                destinationFile = new File(Config.PathEvidenceCentral + "\\" + Runner + ".avi");
                            }
                            if (fileName.contains("html")) {
                                destinationFile = new File(Config.PathEvidenceCentral + "\\" + Runner + ".html");
                            }


                            if (!destinationFile.exists()) {
                                System.out.println("COPY FROM  " + path +"  TO : "+ destinationFile);
                                FileUtils.copyFile(sourceFile, destinationFile);
                            }/*else{
                                System.out.println("EXISTS >>> " + destinationFile);
                                //FileUtils.deleteDirectory(new File(path));
                            }*/
                        }
                    }
                }
            }
                if(Sit.equals("Del")) {
                    FileUtils.deleteDirectory(new File(path));
                }


        } catch (Exception e) {
            listFDirectoriesStream(PathOrigin,pSit);
        }
    }


    @Given("that i remove all folders from path \"([^\"]*)\"$")
    public void thatIremovePathsRespond(String path) throws Exception {
        File folder = new File(path);
        //removeDirectoriesStream(path.toString());
        deleteDirectoryRecursionJava6(new File(path.toString()));
    }

    @Given("that i convert all files from path \"([^\"]*)\"$")
    public void thatIConvertPathsRespond(String path) throws Exception {
        //Lista o diretorio
        File folder = new File(path);

        listCDirectoriesStream(path.toString());
        /*for(String item : arq.split(";")){
            findAllFilesInFolder(new File(path + item));
        }*/
    }


    public static void removeDirectoriesStream(String dir) throws Exception {
        PathOrigin =dir.toString();

        String Dirs =  "";
        String prmRunner = "";
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    //fileList.add(path.getFileName().toString());
                    //System.out.println("LENDO DIR " + path.getFileName().toString());
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
    public static void listCDirectoriesStream(String dir) throws Exception {
        PathOrigin =dir.toString();

        String Dirs =  "";
        String prmRunner = "";
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    //fileList.add(path.getFileName().toString());
                    //System.out.println("LENDO DIR " + path.getFileName().toString());
                    Dirs = path.getFileName().toString() +";"+ Dirs;
                    prmRunner =path.getFileName().toString();
                    System.out.println(Dirs);
                    findAllCFilesInFolder(new File(path.toString()),prmRunner);
                }
            }
        }
        //return Dirs;
    }
    public static void findAllCFilesInFolder(File folder,String Runner) throws Exception {
        try{
            String path = folder.toString();
            String fileName ="";

                for (File file : Objects.requireNonNull(folder.listFiles())) {
                    if (!file.isDirectory()) {
                        fileName = file.getName();
                        if (fileName.contains("avi")) {
                            System.out.println(file.getName());
                            //CHAMA A ROTINA DE TRATAMENTO DO ARQUIVO
                            //saveEvidence(path+"\\",file.getName(),Runner);


                            File destinationFile = null;
                            File sourceFile = new File(folder + "\\" + file.getName());

                            if (fileName.contains("avi")) {
                                destinationFile = new File(Config.PathEvidenceCentral + "\\" + Runner + ".webm");
                            }


                            if (!destinationFile.exists()) {
                                System.out.println("CONVERT  FROM  " + path +"  TO : "+ destinationFile);
                                //processCommand("ffmpeg.exe -i "+ folder + "\\" + file.getName() +" -c:v libvpx-vp9 -crf 30 -b:v 0 -b:a 128k -c:a libopus " + folder + "\\" + file.getName().replace("avi","webm"));
                                processCommand(file.getName());
                            }
                        }
                    }
                }



        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void saveEvidence(String path,String filename,String Runner) throws Exception {
        String evidencia = "";
        String data ="";
        String data1 ="";
        String line;
        File file = new File(path+filename);
        BufferedReader br  = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {
            //System.out.println(st);
            data = data + line;
           // System.out.println(data1);
        }
        br.close();

        System.out.println(Runner);
        //ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        //evidenceDao testdao = (evidenceDao) ac.getBean("evidenceDao");
        //Collection<evidence> testCT = testdao.evidenceGet(Runner);
        //if (testCT.isEmpty()) {
            //testdao.evidenceSave(Runner,data,10);
        WriteToFile(Config.PathEvidenceCentral,Runner,data);

        FileUtils.deleteDirectory(new File(path));

        //}
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

    @After
    public void teardownSteps() throws Exception {
//        Webdriver.quit();
  //      Webdriver.close();
    }


}
