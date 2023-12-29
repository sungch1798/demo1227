package com.example.demo1227.map;

import com.example.demo1227.midel.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cm implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer c=new Customer();
c.setCnumber(rs.getInt("customerNumber"));
c.setCname(rs.getString("customerName"));
c.setPhone(rs.getString("phone"));
c.setCity(rs.getString("city"));
c.setCountry(rs.getString("country"));
c.setCredit(rs.getDouble("creditLimit"));

        return c;
    }

}
