package com.example.demo1227.pd;
import org.springframework.ui.Model;
import com.example.demo1227.data.DBP;
import com.example.demo1227.midel.md;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
@Controller
public class RCont {
    DBP dbp=new DBP();
    @GetMapping("/order")
    public String getOrderList(Model model) throws SQLException {
        ResultSet rs =null;
        ArrayList<md>orders =new ArrayList<>();
        String sql= """
                SELECT
                     orders.orderNumber,
                     orders.orderDate,
                     orders.requiredDate,
                     orders.comments,
                     customers.customerName
                     FROM
                     orders
                     JOIN
                     customers
                     ON
                     orders.customerNumber=customers.customerNumber
                     
                """;
        rs=dbp.getData(sql);
        try {
            while (rs.next()){
                md md1 = new md();
            md1.setOrderN(rs.getInt("orderNumber"));
            md1.setOrderD(rs.getDate("orderDate"));
            md1.setReqD(rs.getDate("requiredDate"));
            md1.setComm(rs.getString("comments"));
            md1.setCname(rs.getString("customerName"));
            orders.add(md1);
            }
            model.addAttribute("orders",orders);
            rs.close();
        }catch (SQLException e){
            System.err.println("ReportController 處理資料發生異常");

        }
        return "odl";
    }
}
