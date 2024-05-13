package com.example.EcoChargerStation.Repository;
import com.example.EcoChargerStation.Dtos.CreateStationDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StationRepository implements IStationRepository {


    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public CreateStationDTO AddStation(CreateStationDTO station) {
        String jpql = "INSERT INTO Point(supplier_id, description, name, address_id)" +
                " VALUES (:supplier_id, :description, :name, :address_id)";
        var result = em.createQuery(jpql).setParameter("supplier_id", station.supplierId())
                .setParameter("description", station.description())
                .setParameter("name", station.name())
                .setParameter("address_id", station.addressId()).executeUpdate();
        return station;
    }
}