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

    /**
     * Rest Controller get request
     * Returns list of temperatures
     */
    @GetMapping()
    public Object getTemps(){
        try {
            return tempService.getTemps();
        }
        catch(Exception e){
            return e.toString();
        }
    }

    /**
     * Rest controller get request
     * @param id
     * Returns a single temperature by id
     */
    @GetMapping("/{id}")
    public Object getTemp(@PathVariable Integer id){
        try {
            return tempService.getTemp(id);
        }
        catch(Exception e){
            return e.toString();
        }
    }

    /**
     * Rest controller post request
     * @param testObject - contains an id and an updated temperature
     * Updates an existing value
     */
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

    /**
     * Rest controller put request
     * @param temp - contains a single temperature value in celsius
     */
    @PutMapping("/{temp}/")
    public Object putTemp(@PathVariable Double temp){
        try {
            tempService.putTemp(temp);
        }catch(Exception e){
            return e.toString();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Rest controller delete request
     * @param id - contains a single id corresponding to a table entry
     */
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
