package com.example.EcoChargerStation.Repository.ConcreteRepositories;

import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.Point;
import com.example.EcoChargerStation.Models.Recharge;
import com.example.EcoChargerStation.Repository.interfaces.IPaymentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;

@Repository
public class PaymentRepository implements IPaymentRepository {


    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public boolean ConfirmPayment(Client id, Point pointId, float value, boolean state) {
        if(ExistAPaymentWithTheseParams(id, pointId)){
            Recharge recharge = new Recharge();
            recharge.setAvailability(state);
            recharge.setRechargeDate("sass"); // Assuming you have a valid date format here
            recharge.setRechargeValue(value);
            recharge.setClient(id);
            recharge.setPointId(pointId);
            em.persist(recharge);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    @Transactional
    public boolean ExistAPaymentWithTheseParams(Client client, Point point){
        Long number = (Long) em.createQuery("SELECT COUNT(c) FROM Recharge c WHERE c.client = :client and c.availability = false and c.pointId = :point")
                .setParameter("client", client)
                .setParameter("point", point)
                .getSingleResult();
        return number > 0;
    }
}
