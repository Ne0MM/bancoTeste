package com.example.bancoTeste.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bancoTeste.dto.ErrorReturn;
import com.example.bancoTeste.dto.LoginRequest;
import com.example.bancoTeste.dto.LoginResponse;
import com.example.bancoTeste.model.Master_admin;
import com.example.bancoTeste.service.Master_adminService;

@RestController
@RequestMapping("/api")
public class Master_adminController {
    
    private final Master_adminService master_adminService;

    public Master_adminController(Master_adminService master_adminService){
        this.master_adminService = master_adminService;
    }

    @GetMapping("")
    public ResponseEntity<List<Master_admin>> getAllMaster_admin(){
        List<Master_admin> master_admins = master_adminService.fetchMaster_admins();
        return ResponseEntity.ok().body(master_admins);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> createMasterAdmin(@RequestBody Master_admin master_admin){

        String username = master_admin.getUsername();

        if(!master_adminService.existsByUsername(username)){
            Master_admin create_Master_admin = master_adminService.create_Master_admin(master_admin);
            return new ResponseEntity<>(create_Master_admin, HttpStatus.CREATED);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorReturn("Username already exists"));
        }

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> logInMasterAdmin(@RequestBody LoginRequest loginRequest){

        LoginResponse response = new LoginResponse();
        Master_admin adminTable = master_adminService.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        response.setId(adminTable.getId());
        return ResponseEntity.ok().body(response);

    }
    
}
