package org.hibernate.DTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Bike {
    private String bikeName;
    @Id
    private int bikeNumber;

    /*@ManyToOne
    @JoinColumn(name="BikeUser_ID")
    private BikeUser bikeUser;*/

    @ManyToMany(mappedBy = "bike")
    private Collection<BikeUser> listOfBikeUsers = new ArrayList<>();

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

   /* public BikeUser getBikeUser() {
        return bikeUser;
    }

    public void setBikeUser(BikeUser bikeUser) {
        this.bikeUser = bikeUser;
    }*/

    public Collection<BikeUser> getListOfBikeUsers() {
        return listOfBikeUsers;
    }

    public void setListOfBikeUsers(Collection<BikeUser> listOfBikeUsers) {
        this.listOfBikeUsers = listOfBikeUsers;
    }
}
