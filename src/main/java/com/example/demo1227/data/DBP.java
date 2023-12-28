package com.example.demo1227.data;
import java.sql.*;
public class DBP {
    public DBP() {

            try {
                Class.forName("org.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println("驅動程式載入失敗,請確認 MariaDB-Java-Connector 是否有載入");
            }
    }
    public ResultSet getData(String sql){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs =null;
        try{
            con=DriverManager.getConnection("jdbc:mariadb://127.0.0.1/classicmodels","root","12345");
            stmt=con.createStatement();
            rs= stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            System.out.println("連線異常" +  e.getMessage());
            return null;
        }

    }
}
