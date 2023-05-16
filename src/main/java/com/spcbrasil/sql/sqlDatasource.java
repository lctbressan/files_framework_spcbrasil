package com.spcbrasil.sql;

import javax.sql.DataSource;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class sqlDatasource {
    private static String url;

    @Bean
    private static DataSource getDataSource(String Env, String Server, String Type) throws IOException, ClassNotFoundException {

        String driverClassName = null;

        if (Type.equals("SQLITE")) {
            driverClassName = "org.sqlite.JDBC";
            //windows platform agent
            if (System.getProperty("os.name").contains("Windows")) {


                if (Env.contains("SPC")) {
                    url = "jdbc:sqlite:\\\\" + Server + "\\bkus\\bkus\\data\\databases\\product.db";
                }

            }


            //linux platform agent
            if (System.getProperty("os.name").contains("Linux")) {
                if (Env.contains("SPC")) {

                    url = "jdbc:sqlite:/mnt/bkus/bkus/data/databases/product.db";
                }


            }

        }

        if(Type.equals("SQLSERVER")) {
            driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            url = "jdbc:sqlserver://10.10.0.1;"
                    + "database=spcbrasil;"
                    + "user=sa;"
                    + "password=teste;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;"
                    + "loginTimeout=30;";
        }

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        return dataSource;
    }

    public static JdbcTemplate getJdbc(String Env,String Server,String Type) throws IOException, ClassNotFoundException {

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource(Env,Server,Type));

        return jdbcTemplate;
    }
}
