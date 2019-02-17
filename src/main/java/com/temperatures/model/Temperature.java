package com.temperatures.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "temperature")
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "temperature", nullable = false)
    private Double celsius;
    @Transient
    private Double fahrenheit;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date", nullable = false,updatable = false)
    private Date createDate;
    @Temporal(TemporalType.DATE)
    @Column(name="update_date", nullable = false)
    private Date updateDate;
    
    public Temperature(){

    }

    public Temperature(Integer id, Double celsius, Date createDate, Date updateDate){
        this.id = id;
        this.celsius = celsius;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Temperature(Double temperature){
        this.celsius = temperature;
        this.fahrenheit = (temperature * 9/5) + 32;
    }

    public Integer getId(){
        return this.id;
    }

    public Double getCelsius(){
        return this.celsius;
    }

    public Double getFahrenheit(){
        return this.fahrenheit;
    }

    public Date getCreateDate(){
        return this.createDate;
    }

    public Date getUpdateDate(){
        return this.updateDate;
    }

    public void setCelsius(Double temperature){
        this.celsius = temperature;
    }

    @PrePersist
    protected void onCreate(){
        updateDate=createDate=new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        updateDate=new Date();
    }

    @PostLoad
    protected void onLoad(){
        this.fahrenheit = (this.celsius * 9/5) + 32;
    }

}
