package com.example.EcoChargerStation.Repository.ConcreteRepositories;

import com.example.EcoChargerStation.Dtos.CreateVehicleDTO;
import com.example.EcoChargerStation.Repository.interfaces.IVehicleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepository implements IVehicleRepository {


    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public CreateVehicleDTO AddVehicle(CreateVehicleDTO vehicle) {
        String jpql = "INSERT INTO Vehicle(brand, model, year, ownerId)" +
                " VALUES (:brand, :model, :year, :ownerId)";
        var result = em.createQuery(jpql).setParameter("brand", vehicle.brand())
                .setParameter("model", vehicle.model())
                .setParameter("year", vehicle.year())
                .setParameter("ownerId", vehicle.ownerId()).executeUpdate();
        return vehicle;
    }

    @Override
    public void DeleteVehicle(long id) {
        String jpql = "DELETE FROM  Vehicle c WHERE c.id = :id";
        em.createQuery(jpql).setParameter("id", id);

    }

    @Override
    public boolean ExistAVehicle(long id) {
        String jqpl = "SELECT COUNT(v) FROM Vehicle v WHERE v.id = :id";
        Long number = (Long) em.createQuery(jqpl).setParameter("id", id).getSingleResult();
        return number > 0;
    }
}
