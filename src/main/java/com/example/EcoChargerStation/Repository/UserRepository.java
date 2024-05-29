package com.example.EcoChargerStation.Repository;

import com.example.EcoChargerStation.Models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository{


    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public User GetUserByLogin(String email, String password) {

        var result = em.createQuery("FROM Client WHERE email = :email and password = :password", User.class).setParameter("email", email).setParameter("password", password).getSingleResult();
        if(result == null){
            result = em.createQuery("FROM Supplier WHERE email = :email and password = :password", User.class).setParameter("email", email).setParameter("password", password).getSingleResult();
        }
        return result;
    }
    @Override
    @Transactional
    public boolean ExistAnUserWithThisParams(String email, String cpf){
        var result = (Long) em.createQuery("SELECT COUNT(c) FROM Client c WHERE c.email = :email or c.cpf = :cpf")
                .setParameter("email", email)
                .setParameter("cpf", cpf).getSingleResult();
        System.out.println(result);
        return result > 0;
    }
    @Override
    @Transactional
    public boolean ExistAnUserWithThisParams(Long id){
        var result = (Long) em.createQuery("SELECT COUNT(c) FROM Client c WHERE c.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        System.out.println(result);
        return result > 0;
    }
    @Transactional
    public void RegisterNewUser(String name, String password, String email, String phone, String userName, String cpf) {
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
    @Transactional
    @Override
    public void DeleteById(Long id) {
        em.createQuery("DELETE FROM Client where id = :id").setParameter("id", id).executeUpdate();
    }
}
