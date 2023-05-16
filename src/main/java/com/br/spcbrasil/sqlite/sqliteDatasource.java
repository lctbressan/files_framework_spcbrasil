package com.br.spcbrasil.sqlite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Configuration
public class sqliteDatasource {
    private static String url;

    @Bean
    private static DataSource getDataSource(String Env,String Server,String Type) throws IOException {
        String driverClassName = "org.sqlite.JDBC";
        if(Type.equals("SQLLITE")) {
        if (Env.equals("BOH")) {
            url = "jdbc:sqlite:\\\\" + Server + "\\boh\\data.sqlite";
            // url = "jdbc:sqlite:C://MediaWorks/BOH/data.sqlite";
        }
        if (Env.equals("BKUS") || Env.equals("BKUS-LD") || Env.equals("BKUS-BF") || Env.equals("BKUS-DISCOUNT") || Env.equals("BKUS-KDS") || Env.equals("BKUS-OPENPOS")) {
            url = "jdbc:sqlite:\\\\" + Server + "\\profiles\\mediaworks\\sources\\repos\\BKUS-Barnett\\data\\databases\\product.db";
        }

        if (Env.equals("BKUS-LDP38") || Env.equals("BKUS-BFP38") || Env.equals("BKUS-KDSP38")) {
            url = "jdbc:sqlite:\\\\" + Server + "\\p38\\mwpos\\data\\databases\\product.db";
        }

        if (Env.equals("POPEYES") || Env.equals("POPEYES-BF") || Env.equals("POPEYES-LD") || Env.equals("poppmix")) {
            url = "jdbc:sqlite:\\\\" + Server + "\\ServerRoot\\mediaworks\\sources\\repos\\mwpos_popeyes\\data\\databases\\product.db";
        }

        if (Env.equals("THUS") || Env.equals("THUS-BF") || Env.equals("THUS-LD")) {
            url = "jdbc:sqlite:\\\\" + Server + "\\ServerRoot\\mediaworks\\sources\\repos\\mwpos_thus\\data\\databases\\product.db";
        }

        if (Env.equals("thusLocal")) {
            url = "jdbc:sqlite:C:\\MediaWorks\\TH-US\\872\\RPOS-872.sqlite.db";
        }

        if (Env.equals("bkuspmix")) {
            url = "jdbc:sqlite:\\\\" + Server + "\\profiles\\mediaworks\\sources\\repos\\BKUS-Barnett\\data\\databases\\rbi_pmix.db";

        }

        if (Env.equals("thuspmix")) {
            url = "jdbc:sqlite:\\\\" + Server + "\\thim_hortons\\data\\databases\\rbi_pmix.db";

        }

        if (Env.equals("BKMEX")) {
            //url = "jdbc:sqlite:\\\\"+ Server +"\\server01\\BRAZILTEST\\mwpos\\mwpos\\data\\databases\\product.db";
            url = "jdbc:sqlite:C:\\MediaWorks\\BKUS-MEX\\POS\\mwpos.old\\mwpos\\data\\databases\\product.db";


        }
    }

        if(Type.equals("SQLSERVER")) {
            driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

            if(System.getProperty("os.name").contains("Windows")) {
                url =  getSqlServreString("C:\\credencialrbi\\credencial.txt");
                System.out.println("WINDOWS CREDENCIALS " + url);
            }
            if(System.getProperty("os.name").contains("Linux")){
                url = getSqlServreString("/home/bressan/credencialrbi/credencial.txt");
                System.out.println("LINUX CREDENCIALS " + url);
            }
            if(System.getProperty("os.name").contains("Mac")){
                url = getSqlServreString("/home/bressan/credencialrbi/credencial.txt");
                System.out.println("LINUX CREDENCIALS " + url);
            }
        }


        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        return dataSource;
    }


    public static JdbcTemplate getJdbc(String Env,String Server,String Type) throws IOException {

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource(Env,Server,Type));

        return jdbcTemplate;
    }

    public static String getSqlServreString(String path) throws IOException {
        String Ret = "";
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);
                Ret = linha;
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();

        return Ret;
    }
}
