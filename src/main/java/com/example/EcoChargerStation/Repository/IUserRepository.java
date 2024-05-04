package com.example.EcoChargerStation.Repository;

import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.User;
import org.springframework.stereotype.Repository;



public interface IUserRepository{
    public void RegisterNewUser(String name, String password, String email, String phone, String userName, String cpf) throws Exception;
}
