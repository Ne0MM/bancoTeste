package com.example.bancoTeste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bancoTeste.model.Banco_items;
import com.example.bancoTeste.repository.Banco_itemsRepository;

@Service
public class Banco_itemsService {

    private final Banco_itemsRepository banco_itemsRepository;

    @Autowired
    public Banco_itemsService(Banco_itemsRepository banco_itemsRepository){
        this.banco_itemsRepository = banco_itemsRepository;
    }

    public List<Banco_items> find_banco_items_by_id(Long shopId){
        return banco_itemsRepository.findByshopId(shopId);
    }

    public Banco_items create_Banco_items(Banco_items banco_items){
        return banco_itemsRepository.save(banco_items);
    }
    
}
