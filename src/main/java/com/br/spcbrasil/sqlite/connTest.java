package com.br.spcbrasil.sqlite;



import java.sql.ResultSet;
        import java.sql.SQLException;
        import javax.swing.JOptionPane;
        import org.sqlite.SQLiteDataSource;
        import org.sqlite.SQLiteJDBCLoader;

public class connTest {

    public static final boolean Connected() throws Exception {
        boolean initialize = SQLiteJDBCLoader.initialize();

        SQLiteDataSource dataSource = new SQLiteDataSource();
        String url = "jdbc:sqlite:\\\\10.10.0.7\\profiles\\mediaworks\\sources\\repos\\BKUS-Barnett\\mwpos_ubuntu64\\mwpos\\data\\databases\\product.db";
        dataSource.setUrl(url);

        int i = 0;
        try {
            ResultSet executeQuery = dataSource.getConnection().createStatement().executeQuery("select * from Product");
            while (executeQuery.next()) {
                i++;
                System.out.println("out: " + executeQuery.getMetaData().getColumnLabel(i));

            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return initialize;

    }
    public static void main(String[] args) throws Exception {
        Connected();
    }
}