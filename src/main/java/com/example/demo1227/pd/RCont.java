package com.example.demo1227.pd;
import com.example.demo1227.serive.CS;
import com.example.demo1227.serive.DBS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.demo1227.data.DBP;
import com.example.demo1227.midel.md;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RCont {
    DBP dbp=new DBP();
    @Autowired
    DBS dbs;
    @Autowired
    CS cs;
    @GetMapping("/test1")
    public String SayHello(Model model){
        String name=dbs.getOrdersAll();
        Long cusa = dbs.countByCountry("USA");
        Long cfr = dbs.countByCountry("france");
        model.addAttribute("name", name);
        model.addAttribute("USA", cusa);
        model.addAttribute("France", cfr);
        return "hello";
    }





    @GetMapping("/order")
    public String getOrderList(Model model) throws SQLException {
        ResultSet rs =null;
        List<md> orders;
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
        orders=dbp.getData(sql);

            model.addAttribute("orders",orders);

        return "odl";
    }
}
