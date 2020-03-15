package org.hibernate.DTO;

import javax.persistence.*;

@Entity
public class Driver {
    @Column(name="DRIVER_NAME")
    private String driverName;
    @Id
    @GeneratedValue
    private int driverId;

    @OneToOne
    @JoinColumn(name = "VEHICLE_ID")
    private  Vehicle vehicle;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
