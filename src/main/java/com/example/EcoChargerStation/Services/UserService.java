package com.example.EcoChargerStation.Services;

import com.example.EcoChargerStation.Exceptions.UserExceptions.AccountHasBeRegisteredException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.IncorrectDataException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.UserNotFoundException;
import com.example.EcoChargerStation.Models.User;
import com.example.EcoChargerStation.Repository.IUserRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    @Autowired
    IUserRepository repository;



    public User login(String email, String password) throws UserNotFoundException {

        if(repository.ExistAnUserWithThisParams(email, password)){
            return repository.GetUserByLogin(email, password);
        }
        throw new UserNotFoundException();
    }

     public void RegisterNewUser(String name, String password, String email, String phone, String userName, String cpf) throws AccountHasBeRegisteredException, IncorrectDataException {

        if(name == null || password == null || email == null || phone == null || userName == null || cpf == null){
            throw new IncorrectDataException();
        }
        if(this.repository.ExistAnUserWithThisParams(email, cpf)){
            throw new AccountHasBeRegisteredException();
        }
        this.repository.RegisterNewUser(name, password, email, phone, userName, cpf);
    }

    public void DeleteWithId(Long id) throws UserNotFoundException{

        if(!this.repository.ExistAnUserWithThisParams(id)){
            throw new UserNotFoundException();
        }
        this.repository.DeleteById(id);
    }

}
