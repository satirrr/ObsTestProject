package com.obs.test.market.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private  int price;
}