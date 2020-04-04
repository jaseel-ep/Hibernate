package org.hibernate.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

public class CrudMain {
    public static void main(String[] args) {
        /*
        CRUD OPERATIONS
         */

      /*   Subjects subjects1 = new Subjects();
        subjects1.setSubject("Math");

         Subjects subjects2 = new Subjects();
        subjects2.setSubject("Science");
         Student student = new Student();
        student.setName("Student name");
        student.getListOfSubjects().add(subjects1);
        student.getListOfSubjects().add(subjects2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // CREATE
         Session session = sessionFactory.openSession();
         Transaction transaction = session.beginTransaction();

        session.save(student);
        session.save(subjects1);
        session.save(subjects2);
         transaction.commit();
         session.close();
         // CREATE- END -Session close

        // READ
         session= sessionFactory.openSession();
         Transaction transaction1 = session.beginTransaction();
        Student student1= session.get(Student.class,1);
        *//* Collection<Subjects> listOfSubjects = student1.getListOfSubjects();
        listOfSubjects.stream().forEach(System.out::println);*//*
        session.close();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

        Collection<Subjects> listOfSubjects2 = student1.getListOfSubjects();
        listOfSubjects2.stream().map(subjects -> subjects.getSubject()).forEach(System.out::println);
     *//*   System.out.println("read-------after session close");
        Subjects tsetSubject=(Subjects) student1.getListOfSubjects();
        System.out.println(tsetSubject.getSubject());*//*
        // READ -END Session close

        // UPDATE  --one way is to update the object and save again with another session

        session= sessionFactory.openSession();
        final Transaction transaction2 = session.beginTransaction();
        student1.setName("updated name");

        session.update(student1);
        transaction2.commit();
        session.close();
        // UPDATE - END Session close

        //Delete
        *//*session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(student1);
        session.getTransaction().commit();
        session.close();*//*
//Delete _end

        // second way OF DELETE
        session = sessionFactory.openSession();
        session.beginTransaction();
         //Student student2 = session.get(Student.class, 1);
       // session.delete(student2);
        session.getTransaction().commit();*/
    }
}
