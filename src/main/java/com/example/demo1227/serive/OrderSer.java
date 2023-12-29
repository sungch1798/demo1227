package com.example.demo1227.serive;

import com.example.demo1227.map.OrderMapper;
import com.example.demo1227.midel.Order1;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderSer {
    @Autowired
    JdbcTemplate template;
    public List<Order1> getAll() {
        return template.query("select * from orders",new OrderMapper());

    }
    public List<Order1> getoid(int ono) {
        return template.query("select * from orders where orderNumber=" + ono, new OrderMapper());
    }
    public List<Order1> getocn(int cno) {
        return template.query("select * from orders where customerNumber=" + cno, new OrderMapper());
    }


}
