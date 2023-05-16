package com.br.spcbrasil.sqlite;

import java.sql.*;

public class connect {


    public static Connection openDb() throws SQLException {
        String url = "jdbc:sqlite:\\\\10.10.0.7\\profiles\\mediaworks\\sources\\repos\\BKUS-Barnett\\mwpos_ubuntu64\\mwpos\\data\\databases\\product.db";
        Connection conn = null;
         conn = DriverManager.getConnection(url);
        return conn;
    }

    public static void main(String[] args) {
        connect app = new connect();
        app.selectAll();
    }

    public void selectAll(){
            String vlsql = "SELECT ";
            vlsql = vlsql + " p.ProductName";
            vlsql = vlsql + " ,pn.NavId";
            vlsql = vlsql + " from ProductNavigation pn inner join Navigation n on pn.NavId = n.NavId";
            vlsql = vlsql + " inner join Product p on pn.ProductCode = p.ProductCode ";
            vlsql = vlsql + " where n.Name in('Whoppers','Bacon Kings','Stacker Kings','Impossible','Special Whoppers','Angry Whoppers','Bacon Kings LTOs','Patty Menu')";
            vlsql = vlsql + " and  p.ProductName not in ('Impossible S/E/C Croissanwich','Impossible S/E/C Biscuit')";
            vlsql = vlsql + " order by n.Name , p.ProductName";

            try (Connection conn = this.openDb();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(vlsql)){

                // loop through the result set
                while (rs.next()) {
                    System.out.println(rs.getString("ProductName"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }




}
