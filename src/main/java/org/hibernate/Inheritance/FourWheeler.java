package org.hibernate.Inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("4-Wheel")
public class FourWheeler extends InheritenceVehicle {
    private String roofTop;

    public String getRoofTop() {
        return roofTop;
    }

    public void setRoofTop(String roofTop) {
        this.roofTop = roofTop;
    }
}
