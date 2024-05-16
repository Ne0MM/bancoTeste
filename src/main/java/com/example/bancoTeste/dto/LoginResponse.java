package com.example.bancoTeste.dto;

public class LoginResponse {

    private long id;
    
    public LoginResponse(){
    }

    public LoginResponse(Long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }
}
