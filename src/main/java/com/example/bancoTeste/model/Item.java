package com.example.bancoTeste.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long shop_id;
    private String name;
    private float price;

    public Item(){
    }

    public Item(long shop_id, String name, float price){
        this.shop_id = shop_id;
        this.name = name;
        this.price = price;
    }

    public long getShopId(){
        return shop_id;
    }

    public float getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }
    
}
