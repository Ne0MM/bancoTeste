package com.example.bancoTeste.dto;

public class ErrorReturn {

    private String error_type;
    
    public ErrorReturn(){}

    public ErrorReturn(String error_type){
        this.error_type = error_type;
    }

    public String getErrorType(){
        return error_type;
    }

    public void setErrorType(String error_type){
        this.error_type = error_type;
    }
    
}
