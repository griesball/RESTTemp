package com.temperatures.controller;

import com.temperatures.service.TemperatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping(path = "/temp")
public class TemperatureController {

    private TemperatureService tempService = new TemperatureService();

    @GetMapping()
    public Object getTemps(){
        try {
            return tempService.getTemps();
        }
        catch(Exception e){
            return e.toString();
        }
    }

    @PostMapping()
    public Object postTemp(@RequestBody HashMap<String,Object> testObject){
        try {
            Integer id = Integer.parseInt(testObject.get("id").toString());
            Double newTemp = Double.parseDouble(testObject.get("temperature").toString());
            tempService.postTemp(id, newTemp);
        }catch(Exception e){
            return e.toString();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{temp}/")
    public Object putTemp(@PathVariable Double temp){
        try {
            tempService.putTemp(temp);
        }catch(Exception e){
            return e.toString();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Object deleteTemp(@PathVariable Integer id){
        try{
            tempService.deleteTemp(id);
        }catch(Exception e){
            return e.toString();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
