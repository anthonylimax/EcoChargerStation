package com.example.EcoChargerStation.Repository;

import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepository implements IUserRepository{


    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public User GetUserByLogin(String email, String password) throws Exception {

        var result = em.createQuery("FROM Client WHERE email = :email and password = :password", User.class).setParameter("email", email).setParameter("password", password).getSingleResult();
        if(result == null){
            result = em.createQuery("FROM Supplier WHERE email = :email and password = :password", User.class).setParameter("email", email).setParameter("password", password).getSingleResult();
        }
        return result;
    }


}
