package org.hibernate.DTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class BikeUser {
    private String userName;
    @Id
    private int userId;

   //@OneToMany  //-- Used if we need a separate table for mapping (3rd table)
    @OneToMany(mappedBy = "bikeUser")  // used if we need to map every bike to a bike user in bike table;
    // mappedBy - the variable in Bike class that needs to be mapped

    //We can have ManyToOne relationShip from Bike to BikeUser also. // @ManyToOne should be used in Bike class
    //OneToMany creates a third column which has 2 columns (primary key from both tables mapped each other)
    // joinColumns -- to specify name of the column name for this entity (ie BikeUser)
    //@inverseJoinColumns -- to specify the column name for the mapped entity (ie Bike here)
   // @JoinTable(name="BIKE_USER",joinColumns = @JoinColumn(name="BikeUser_ID"),inverseJoinColumns = @JoinColumn(name="Bike_NUMBER"))
    private Collection <Bike> bike = new ArrayList();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Collection<Bike> getBike() {
        return bike;
    }

    public void setBike(Collection<Bike> bike) {
        this.bike = bike;
    }
}
