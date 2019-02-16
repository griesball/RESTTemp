package com.temperatures.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double temperature;
    private Date createDate;
    private Date updateDate;

    public Temperature(){

    }

    public Temperature(Integer id, Double temperature, Date createDate, Date updateDate){
        this.id = id;
        this.temperature = temperature;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId(){
        return this.id;
    }

    public Double getTemperature(){
        return this.temperature;
    }

    public Date getCreateDate(){
        return this.createDate;
    }

    public Date getUpdateDate(){
        return this.updateDate;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setTemperature(Double temperature){
        this.temperature = temperature;
    }

    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }

    public void setUpdateDate(Date updateDate){

    }
}
