package com.example.bancoTeste.dto;

public class CreateBancoRequest {

    private long shop_id;
    private String name;

    public CreateBancoRequest(){

    }

    public CreateBancoRequest(long shop_id, String name){
        this.shop_id = shop_id;
        this.name = name;
    }

    public long getShopId(){
        return shop_id;
    }

    public String getName(){
        return name;
    }
    
}
