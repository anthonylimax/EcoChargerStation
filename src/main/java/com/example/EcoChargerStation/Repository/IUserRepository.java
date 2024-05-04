package com.example.EcoChargerStation.Repository;

import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.User;
import org.springframework.stereotype.Repository;



public interface IUserRepository{
    public User GetUserByLogin(String email, String password) throws Exception;
}
