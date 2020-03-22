package org.hibernate.Inheritance;

import javax.persistence.*;

@Entity()
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Vehicle")  // discriminatorType = DiscriminatorType.INTEGER -- discriminatorType is allowed , whic has possible
// values like String, Integer , Char etc...
@DiscriminatorValue("Vehicle")
public class InheritenceVehicle {
    private String vehicleName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
