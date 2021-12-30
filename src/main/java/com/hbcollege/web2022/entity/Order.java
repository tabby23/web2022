package com.hbcollege.web2022.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String name;
    private String pic;
    private float price;
    private boolean pay;
    private boolean send;
    private boolean receive;
}
