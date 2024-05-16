package com.example.bancoTeste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bancoTeste.model.Master_admin;
import com.example.bancoTeste.repository.Master_adminRepository;

@Service
public class Master_adminService {

    private final Master_adminRepository master_adminRepository;

    @Autowired
    public Master_adminService(Master_adminRepository master_adminRepository){
        this.master_adminRepository = master_adminRepository;
    }

    public Master_admin create_Master_admin(Master_admin master_admin){
        return master_adminRepository.save(master_admin);
    }
    
    public List<Master_admin> fetchMaster_admins(){
        return master_adminRepository.findAll();
    }

    public Master_admin findByUsernameAndPassword(String username, String password){
        return master_adminRepository.findByUsernameAndPassword(username, password);
    }
    
    public boolean existsByUsername(String Username){
        return master_adminRepository.existsByUsername(Username);
    }

}
