package com.temperatures.controller;

import com.temperatures.model.Temperature;
import com.temperatures.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/temp")
public class TemperatureController {

    @Autowired
    TemperatureService tempService;

    @GetMapping()
    public @ResponseBody List<Temperature> getTemps(){
        //TODO
        return new ArrayList<>();
    }

    @PostMapping()
    public @ResponseBody List<Temperature> postTemp(){
        //TODO
        return new ArrayList<>();
    }

    @PutMapping()
    public void putTemp(){
        //TODO
    }

    @DeleteMapping("/{id}")
    public void deleteTemp(@PathVariable Integer id){
        //TODO
    }

}
