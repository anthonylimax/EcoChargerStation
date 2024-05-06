package com.example.EcoChargerStation.Controller;

import com.example.EcoChargerStation.Dtos.CreateNewClientDTO;
import com.example.EcoChargerStation.Models.Supplier;
import com.example.EcoChargerStation.Models.User;
import com.example.EcoChargerStation.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserRepository repository;


    @PostMapping("/createclient")
    public ResponseEntity<User> createClient(@RequestBody CreateNewClientDTO login){
        try{
            System.out.println(login.cpf() + login.userName());
            repository.RegisterNewUser(login.name(), login.password(), login.email(),login.phone(), login.userName(),login.cpf());

            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}