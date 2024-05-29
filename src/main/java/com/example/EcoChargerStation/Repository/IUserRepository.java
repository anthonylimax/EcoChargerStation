package com.example.EcoChargerStation.Repository;

import com.example.EcoChargerStation.Models.User;
import jakarta.transaction.Transactional;

public interface IUserRepository{
    public User GetUserByLogin(String email, String password);
    public boolean ExistAnUserWithThisParams(String email, String cpf);
    public boolean ExistAnUserWithThisParams(Long id);
    public void DeleteById(Long id);
    public void RegisterNewUser(String name, String password, String email, String phone, String userName, String cpf);
}
