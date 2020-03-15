package org.hibernate;

import org.hibernate.DTO.*;
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
       // userDetails.setHomeAddress(HomeAddress);
        //userDetails.setOfficeAddress(officeAddress);
        userDetails.setLogin(login);
       /* userDetails.getListOfAdresses().add(officeAddress);
        userDetails.getListOfAdresses().add(HomeAddress);*/
       userDetails.getAddressList().add(officeAddress);
       userDetails.getAddressList().add(HomeAddress);


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
       /* TestDTO test = new TestDTO();
        test.setName("JAS");*/

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(userDetails);
            session.getTransaction().commit();
        }


        Vehicle vehicle = new Vehicle();
       // vehicle.setVehicleId(1);
        vehicle.setVehicleName("KTM");

        Driver driver = new Driver();
      //  driver.setDriverId(1);
        driver.setDriverName("Some name");
        driver.setVehicle(vehicle);


        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
           session.save(vehicle);  // We need to persist Vehicle object explicitly , even though there is a one to one mapping between Driver and Vehicle.
           session.save(driver);
           transaction.commit();
        }


    }

}
