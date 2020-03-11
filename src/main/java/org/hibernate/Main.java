package org.hibernate;

import org.hibernate.DTO.Address;
import org.hibernate.DTO.Login;
import org.hibernate.DTO.TestDTO;
import org.hibernate.DTO.UserDetails;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        Address HomeAddress = new Address();
        HomeAddress.setCity("Bangalore");
        HomeAddress.setStreet("Street name");
        HomeAddress.setPincode("560000");

        Address officeAddress = new Address();
        officeAddress.setStreet("office Street");
        officeAddress.setPincode("560101");
        officeAddress.setCity("bangalore");

        Login login = new Login();
        login.setLoginID("loginid");
        login.setLoginPassword("password");

        //  userDetails.setUserID(6);
        userDetails.setUserName("Second user");
        userDetails.setJoinedDate(new Date());
        userDetails.setDescription("this is the description for the user.");
        userDetails.setPassWord("password");
        userDetails.setHomeAddress(HomeAddress);
        userDetails.setOfficeAddress(officeAddress);
        userDetails.setLogin(login);


        // SessionFactory is an heavy Object. Only one session factory should be there in an entire application.
     /*   SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // Inserting into DB
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //session.persist(userDetails);
        session.save(userDetails);
        session.getTransaction().commit();
        session.close();

        userDetails=null;
        // Fetching from DB
        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails=session.get(UserDetails.class,6);
        System.out.println(userDetails);*/

        // Using Try with resources
        TestDTO test = new TestDTO();
        test.setName("JAS");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(test);
            session.getTransaction().commit();
        }
/*
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            UserDetails user = session.get(UserDetails.class, login);
            System.out.println(user);

        }*/


    }

}
