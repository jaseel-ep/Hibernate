package org.hibernate.CRUD;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Student {
    private String name;
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private Collection <Subjects> listOfSubjects= new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Subjects> getListOfSubjects() {
        return listOfSubjects;
    }

    public void setListOfSubjects(Collection<Subjects> listOfSubjects) {
        this.listOfSubjects = listOfSubjects;
    }
}
