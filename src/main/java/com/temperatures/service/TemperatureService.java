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
        Iterable<Temperature> source = tempRepo.findAll();
        List<Temperature> target = new ArrayList<>();
        source.forEach(target::add);
        return target;
    }

    public Temperature getTemp(Integer id){
        return tempRepo.findOne(id);
    }

    public void postTemp(Integer id, Double newTemp){
        Temperature oldTemp = tempRepo.findOne(id);
        oldTemp.setCelsius(newTemp);
        tempRepo.save(oldTemp);
    }

    public void putTemp(Double temp){
        Temperature newTemp = new Temperature(temp);
        tempRepo.save(newTemp);
    }

    public void deleteTemp(Integer id){
        tempRepo.delete(id);
    }

    public void deleteAll(){
        tempRepo.deleteAll();
    }
}
