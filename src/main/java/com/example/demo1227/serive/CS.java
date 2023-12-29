package com.example.demo1227.serive;

import com.example.demo1227.map.Cm;
import com.example.demo1227.midel.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CS {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Customer> getCustomerAll(){
        Cm cmapper = new Cm();
        List<Customer>allcustomer = jdbcTemplate.query("select * from customers",cmapper);
return allcustomer;
    }
}
