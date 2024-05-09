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

    public void RegisterNewUser(String name, String password, String email, String phone, String userName, String cpf) throws Exception {
        String jpql = "INSERT INTO Client(email, name, password, phone, userName, cpf)" +
                " VALUES (:email, :name, :password, :phone, :userName, :cpf)";
        var query = em.createQuery(jpql)
                .setParameter("email", email)
                .setParameter("name", name)
                .setParameter("password", password)
                .setParameter("phone", phone)
                .setParameter("userName", userName)
                .setParameter("cpf", cpf);
        int result = query.executeUpdate();
        System.out.println(result);
    }
}
