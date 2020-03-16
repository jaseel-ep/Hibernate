package org.hibernate.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bike {
    private String bikeName;
    @Id
    private int bikeNumber;

    @ManyToOne
    @JoinColumn(name="BikeUser_ID")
    private BikeUser bikeUser;

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public int getBikeNumber() {
        return bikeNumber;
    }

    public void setBikeNumber(int bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public BikeUser getBikeUser() {
        return bikeUser;
    }

    public void setBikeUser(BikeUser bikeUser) {
        this.bikeUser = bikeUser;
    }
}
