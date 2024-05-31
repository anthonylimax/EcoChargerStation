package com.example.EcoChargerStation.Services;


import com.example.EcoChargerStation.Dtos.CreatePointDTO;
import com.example.EcoChargerStation.Exceptions.PointExceptions.IncorrectDataException;
import com.example.EcoChargerStation.Exceptions.PointExceptions.PointNotFoundException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.UserNotFoundException;
import com.example.EcoChargerStation.Models.Point;
import com.example.EcoChargerStation.Repository.interfaces.IPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointServices {

    @Autowired
    IPointRepository repository;


    public CreatePointDTO AddNewPoint(CreatePointDTO createPointDTO) throws IncorrectDataException {
        if(createPointDTO.stationId() != null){
            return repository.AddPoint(createPointDTO);
        }
        throw new IncorrectDataException();
    }

    public Point getPointById(Long id) throws PointNotFoundException {
        if(this.repository.ExistPointWithThisId(id)){
            return this.repository.GetPointById(id);
        }
        else{
            throw new PointNotFoundException();
        }
    }
}
