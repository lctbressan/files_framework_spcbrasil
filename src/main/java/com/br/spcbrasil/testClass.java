package com.br.spcbrasil;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class testClass {

    public static void main(String[] args) throws Exception {
        //System.out.println( obterDataSemana("TER"));
        //ManipularJson mj = new ManipularJson();
       // System.out.println(mj.dataAtual());

        //listFolderStructure("mediaworks","brt125243","10.10.0.7",22,"python server.py");
        //pmix("");
    //files();

        //DiffTime();
rouddup();
    }



        public static void rouddup(){

            int min = 1; // Minimum value of range
            int max = 4; // Maximum value of range
            // Print the min and max
            System.out.println("Random value in int from "+ min + " to " + max + ":");
            // Generate random int value from min to max
            int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
            // Printing the generated random numbers
            System.out.println(random_int);

        }


    public static void files(){

        String pathCucumber = "/home/braziltest/SPCBR/Run_test";

        File folder = new File(pathCucumber);
        if (!folder.exists()) {
            if (folder.mkdir()) {
               } else {
                System.out.println("Falha ao criar diretório!");
            }
        }
    }

    public static String obterDataSemana(String diaSemana) throws Exception {
        Calendar calendar = Calendar.getInstance();
        Date dataHj = new Date();
        calendar.setTime(dataHj);
        LocalDate ld = LocalDate.now();
        DayOfWeek dow = ld.getDayOfWeek();
        int value = dow.getValue();
        calendar.setFirstDayOfWeek(value);
        switch (diaSemana) {
            case "SAB":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                break;
            case "DOM":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                break;
            case "SEG":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                break;
            case "TER":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                break;
            case "QUA":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                break;
            case "QUI":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                break;
            case "SEX":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                break;
            default:
                throw new Exception("Opção de menu inválida");
        }
        SimpleDateFormat format1 = new SimpleDateFormat("ddMMyyyy");
        String formatted = format1.format(calendar.getTime());
        //System.out.println(formatted);
        return  formatted;
    }


public static void DiffTime() throws ParseException {
   /* String time1 = "18:00:00";
    String time2 = "19:00:00";

    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    Date date1 = format.parse(time1);
    Date date2 = format.parse(time2);
    long difference = date2.getTime() - date1.getTime();
    System.out.println((difference/1000)/60);*/
    Date d1 = new Date();
    Date d2 = new Date();
   // d1, d2 are dates
    System.out.println(d1);
    System.out.println(d2);
    long diff = d2.getTime() - d1.getTime();

    long diffSeconds = diff / 1000 % 60;
    long diffMinutes = diff / (60 * 1000) % 60;
    long diffHours = diff / (60 * 60 * 1000) % 24;
    long diffDays = diff / (24 * 60 * 60 * 1000);

    System.out.print(diffDays + " days, ");
    System.out.print(diffHours + " hours, ");
    System.out.print(diffMinutes + " minutes, ");
    System.out.print(diffSeconds + " seconds.");
}




}
