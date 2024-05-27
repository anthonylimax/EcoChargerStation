package com.example.EcoChargerStation.Repository;

import com.example.EcoChargerStation.Models.User;

public interface IUserRepository{
    public User GetUserByLogin(String email, String password) throws Exception;
    public void RegisterNewUser(String name, String password, String email, String phone, String userName, String cpf) throws Exception;
}
