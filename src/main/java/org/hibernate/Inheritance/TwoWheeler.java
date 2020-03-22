package org.hibernate.Inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2-Wheeler")
public class TwoWheeler extends InheritenceVehicle {
    private String swingArm;

    public String getSwingArm() {
        return swingArm;
    }

    public void setSwingArm(String swingArm) {
        this.swingArm = swingArm;
    }
}
