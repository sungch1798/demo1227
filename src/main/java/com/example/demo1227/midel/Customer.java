package com.example.demo1227.midel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Customer {
    private int cnumber;
    private String cname;
    private String phone;
    private String city;
    private String country;
    private Double credit;
}
