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
    private Date create_date;
    private Date update_date;

    public Temperature(){

    }

    public Temperature(Integer id, Double temperature, Date createDate, Date updateDate){
        this.id = id;
        this.temperature = temperature;
        this.create_date = createDate;
        this.update_date = updateDate;
    }

    public Integer getId(){
        return this.id;
    }

    public Double getTemperature(){
        return this.temperature;
    }

    public Date getCreateDate(){
        return this.create_date;
    }

    public Date getUpdateDate(){
        return this.update_date;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setTemperature(Double temperature){
        this.temperature = temperature;
    }

    public void setCreateDate(Date createDate){
        this.create_date = createDate;
    }

    public void setUpdateDate(Date updateDate){
        this.update_date = updateDate;
    }
}
