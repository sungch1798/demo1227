package com.example.demo1227.data;
import com.example.demo1227.midel.md;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBP {
    public DBP() {

            try {
                Class.forName("org.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println("驅動程式載入失敗,請確認 MariaDB-Java-Connector 是否有載入");
            }
    }
    public List<md> getData(String sql){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs =null;
        ArrayList<md> orders = new ArrayList<>();
        try{
            con=DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3307/classicmodels","root","12345");
            stmt=con.createStatement();
            rs= stmt.executeQuery(sql);
            while (rs.next()){
                md md1 = new md();
                md1.setOrderN(rs.getInt("orderNumber"));
                md1.setOrderD(rs.getDate("orderDate"));
                md1.setReqD(rs.getDate("requiredDate"));
                md1.setComm(rs.getString("comments"));
                md1.setCname(rs.getString("customerName"));
                orders.add(md1);
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("連線異常" +  e.getMessage());
            return null;
        }
    return orders;
    }
}
