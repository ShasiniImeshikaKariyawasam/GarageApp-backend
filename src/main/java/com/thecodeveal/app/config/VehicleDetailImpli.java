package com.thecodeveal.app.config;

public class VehicleDetailImpli {

    private Long id;
    private String vehicleNum;
    private String email;
    private String type;

    public VehicleDetailImpli(Long id, String email, String type, String vehicleNum) {
        this.id = id;
        this.email = email;
        this.type = type;
        this.vehicleNum = vehicleNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

}
