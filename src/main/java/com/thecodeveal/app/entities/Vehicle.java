package com.thecodeveal.app.entities;

import javax.persistence.*;

@Table(name = "vehicle")
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "vehicleNum", unique = true)
    private String vehicleNum;

    @Column(name = "email")
    private String email;

    @Column(name = "type")
    private String type;

    public Vehicle(String email,String type,String vehicleNum) {
        this.email = email;
        this.type = type;
        this.vehicleNum = vehicleNum;
    }

    public Vehicle() {

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}
