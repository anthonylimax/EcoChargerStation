package com.example.EcoChargerStation.Repository.interfaces;


import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.Point;

public interface IPaymentRepository {
    public boolean ConfirmPayment(Client id, Point pointId, float value,  boolean state);
    public boolean ExistAPaymentWithTheseParams(Client client, Point point);
}
