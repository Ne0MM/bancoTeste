package com.example.bancoTeste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bancoTeste.model.Master_admin;

@Repository
public interface Master_adminRepository extends JpaRepository<Master_admin, Long>{

    @Query("SELECT m FROM Master_admin m WHERE m.username = ?1 AND m.password = ?2")
    public Master_admin findByUsernameAndPassword(String username, String password);

    @Query("SELECT COUNT(m) > 0 FROM Master_admin m WHERE m.username = ?1")
    public boolean existsByUsername(String username);

}