package com.example.demo1227.serive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DBS {
    @Autowired
    JdbcTemplate jdbcTemplate;   // 等同 Statement


    public String getOrdersAll() {
        String sql = "select customerName from customers where customerNumber = 151";
        // queryForObject 要確定 sql 只會回傳一個欄位  哪一種類型 請在地二個參數告知
        String name = jdbcTemplate.queryForObject(sql,String.class);

        return name;
    }

    public Long countByCountry(String cname) {
        String sql = "select count(*) from customers where country='" + cname +"'";
        // queryForObject 要確定 sql 只會回傳一個欄位  哪一種類型 請在地二個參數告知
        Long cnt = jdbcTemplate.queryForObject(sql,Long.class);
        return cnt;
    }
}
