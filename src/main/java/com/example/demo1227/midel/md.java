package com.example.demo1227.midel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class md {
    int orderN;
    Date orderD;
    Date reqD;
    String comm;
    String cname;
}
