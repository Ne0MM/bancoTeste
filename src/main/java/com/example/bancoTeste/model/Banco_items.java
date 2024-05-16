package com.example.bancoTeste.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Banco_items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long shopId;
    private String name;

    public Banco_items(){

    }

    public Banco_items(long shopId, String name){
        this.shopId = shopId;
        this.name = name;
    }

    public long getId(){
        return this.id;
    }

    public Long getShopId(){
        return this.shopId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
    
}
