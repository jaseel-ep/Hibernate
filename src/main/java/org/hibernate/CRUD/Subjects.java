package org.hibernate.CRUD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subjects {

    private String subject;
    @Id @GeneratedValue
    private int id;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "subject='" + subject + '\'' +
                ", id=" + id +
                '}';
    }
}
