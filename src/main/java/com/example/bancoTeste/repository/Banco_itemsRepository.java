package com.example.bancoTeste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bancoTeste.model.Banco_items;

@Repository
public interface Banco_itemsRepository extends JpaRepository<Banco_items, Long>{

    @Query("SELECT b from Banco_items b WHERE b.shopId = ?1")
    public List<Banco_items> findByshopId(long shopId);

}