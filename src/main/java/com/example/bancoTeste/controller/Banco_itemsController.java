package com.example.bancoTeste.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bancoTeste.dto.ErrorReturn;
import com.example.bancoTeste.model.Banco_items;
import com.example.bancoTeste.service.Banco_itemsService;

@RestController
@RequestMapping("/api")
public class Banco_itemsController {

    private final Banco_itemsService banco_itemsService;

    public Banco_itemsController(Banco_itemsService banco_itemsService){
        this.banco_itemsService = banco_itemsService;
    }

    @PostMapping("/banco_items/by_id")
    public ResponseEntity<List<Banco_items>> getAllBancoItems(@RequestBody Banco_items banco_items){

        long shop_id = banco_items.getShopId();
        List<Banco_items> banco_items_response = banco_itemsService.find_banco_items_by_id(shop_id);
        return ResponseEntity.ok().body(banco_items_response);
    }

    @PostMapping("/banco_items")
    public ResponseEntity<?> createBancoItems(@RequestBody Banco_items banco_items){

        if(banco_items.getShopId() != null){
            Banco_items create_banco_items = banco_itemsService.create_Banco_items(banco_items);
            return ResponseEntity.ok().body(create_banco_items);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorReturn("Shop_id is not valid"));
        }

    }
    
}
