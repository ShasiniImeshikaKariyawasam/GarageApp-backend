package com.thecodeveal.app.responses;

public class VehicleInfo {

    private String vehicleNum;
    private long ownerId;
    private String type;

    public VehicleInfo(long ownerId,String type,String vehicleNum) {
        this.ownerId = ownerId;
        this.type = type;
        this.vehicleNum = vehicleNum;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
