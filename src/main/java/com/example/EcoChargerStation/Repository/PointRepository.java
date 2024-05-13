package com.example.EcoChargerStation.Repository;

import com.example.EcoChargerStation.Dtos.CreatePointDTO;
import com.example.EcoChargerStation.Models.Point;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class PointRepository implements IPointRepository {


    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public CreatePointDTO AddPoint(CreatePointDTO point) {
        String jpql = "INSERT INTO Point(stationId, connectorType, price, availability)" +
                " VALUES (:stationId, :connectorType, :price, :availability)";
        var result = em.createQuery(jpql).setParameter("stationId", point.stationId())
                .setParameter("connectorType", point.connectorType())
                .setParameter("price", point.price())
                .setParameter("availability", point.availability()).executeUpdate();
        return point;
    }
}