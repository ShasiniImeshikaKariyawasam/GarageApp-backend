package com.thecodeveal.app.responses;

public class VehicleInfo {

    private String vehicleNum;
    private String email;
    private String type;

    public VehicleInfo(String email,String type,String vehicleNum) {
        this.email = email;
        this.type = type;
        this.vehicleNum = vehicleNum;
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
