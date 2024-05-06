package com.example.EcoChargerStation.Repository;

import com.example.EcoChargerStation.Dtos.CreateVehicleDTO;
import com.example.EcoChargerStation.Models.Vehicle;
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
}
