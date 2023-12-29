package com.example.demo1227.map;

import com.example.demo1227.midel.Order1;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
public class OrderMapper implements RowMapper<Order1> {
    @Override
    public Order1 mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order1 order = new Order1();
        order.setOrderNumber( rs.getInt("orderNumber"));
        order.setOrderDate(rs.getDate("orderDate"));
        order.setRequiredDate(rs.getDate("requiredDate"));
        order.setShippedDate(rs.getDate("shippedDate"));
        order.setShippedDate(rs.getDate("shippedDate"));
        order.setComments(rs.getString("comments"));
        order.setCustomerNumber(rs.getInt("customerNumber"));
        order.setStatus(rs.getString("status"));
        return  order;
    }

}
