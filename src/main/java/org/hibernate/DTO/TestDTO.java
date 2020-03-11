package org.hibernate.DTO;

import javax.persistence.*;

@Entity(name = "Test")
public class TestDTO {

    private String name;

    private int ID;

    @Column(name = "Custom_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
