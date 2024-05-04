package com.example.EcoChargerStation.Controller;

import com.example.EcoChargerStation.Dtos.CreateNewClientDTO;
import com.example.EcoChargerStation.Dtos.CreateNewSupplierDTO;
import com.example.EcoChargerStation.Dtos.LoginUserDTO;
import com.example.EcoChargerStation.Models.Supplier;
import com.example.EcoChargerStation.Models.User;
import com.example.EcoChargerStation.Repository.IUserRepository;
import jakarta.persistence.Entity;
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
    @PostMapping("/createSupplier")
    public ResponseEntity<Supplier> createSupplier(@RequestBody CreateNewSupplierDTO login){
        try{
            System.out.println(login.cnpj() + login.userName());
            repository.RegisterNewSupplier(login.name(), login.password(), login.email(),login.phone(), login.userName(),login.cnpj());
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginUserDTO login){
        try{
            var result = repository.GetUserByLogin(login.email(), login.password());
            if(result == null){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
            else{
                return ResponseEntity.status(HttpStatus.OK).body(result);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
