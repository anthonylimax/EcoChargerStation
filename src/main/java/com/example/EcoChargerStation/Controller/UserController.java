package com.example.EcoChargerStation.Controller;

import com.example.EcoChargerStation.Dtos.ErrorBody;
import com.example.EcoChargerStation.Dtos.LoginUserDTO;
import com.example.EcoChargerStation.Dtos.CreateNewClientDTO;
import com.example.EcoChargerStation.Exceptions.UserExceptions.AccountHasBeRegisteredException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.IncorrectDataException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.UserNotFoundException;
import com.example.EcoChargerStation.Models.User;
import com.example.EcoChargerStation.Repository.IUserRepository;
import com.example.EcoChargerStation.Repository.UserRepository;
import com.example.EcoChargerStation.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.ReplicateScaleFilter;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginUserDTO login){
        try{
            return ResponseEntity.ok(userService.login(login.email(), login.password()));
        }
        catch(UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id){
        try{
            userService.DeleteWithId(id);
            return ResponseEntity.ok().body(null);
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        }
    }

    @PostMapping("/createclient")
    public ResponseEntity createClient(@RequestBody CreateNewClientDTO login){
        try{

            System.out.println(login);
            userService.RegisterNewUser(login.name(), login.password(), login.email(),login.phone(), login.userName(),login.cpf());
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
        catch(AccountHasBeRegisteredException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        } catch (IncorrectDataException e) {
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
        }
    }

}
