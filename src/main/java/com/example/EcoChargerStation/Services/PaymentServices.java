package com.example.EcoChargerStation.Services;
import com.example.EcoChargerStation.Exceptions.PointExceptions.PointNotFoundException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.UserNotFoundException;
import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.Point;
import com.example.EcoChargerStation.Repository.interfaces.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {

    @Autowired
    IPaymentRepository paymentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PointServices pointServices;


    public boolean ConfirmPayment(Long id, Long pointId, float value) throws UserNotFoundException, PointNotFoundException {

        Client client = this.userService.GetClientById(id);
        Point point = this.pointServices.getPointById(pointId);
        return this.paymentRepository.ConfirmPayment(client, point, value, true);
    }
    public boolean CreatePayment(Long id, Long pointId, float value) throws UserNotFoundException, PointNotFoundException {
        Client client = this.userService.GetClientById(id);
        Point point = this.pointServices.getPointById(pointId);
        return this.paymentRepository.ConfirmPayment(client, point, value, false);
    }
}
