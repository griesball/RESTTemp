package com.temperatures.service;

import com.temperatures.model.Temperature;
import com.temperatures.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureService {

    @Autowired
    private TemperatureRepository tempRepo;

    public List<Temperature> getTemps(){

        //TODO
        return new ArrayList<>();
    }

    public List<Temperature> postTemp(){

        //TODO
        return new ArrayList<>();
    }

    public void putTemp(){
        //TODO
    }

    public void deleteTemp(){
        //TODO
    }
}
