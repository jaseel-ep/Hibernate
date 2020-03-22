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

        Bike bike1 = new Bike();
        Bike bike2 = new Bike();
        bike1.setBikeName("KTM");

        bike1.setBikeNumber(100);
        bike2.setBikeName("Ducati");
        bike2.setBikeNumber(999);

        BikeUser bikeUser = new BikeUser();
        bikeUser.setUserId(1);
        bikeUser.setUserName("Biker");
        bikeUser.getBike().add(bike1);
        bikeUser.getBike().add(bike2);

        BikeUser bikeUser1 = new BikeUser();
        bikeUser1.setUserName("second user");
        bikeUser1.setUserId(2);
        bikeUser1.getBike().add(bike1);
        bikeUser1.getBike().add(bike2);
       /* bike1.setBikeUser(bikeUser);
        bike2.setBikeUser(bikeUser);*/
       bike1.getListOfBikeUsers().add(bikeUser);
       bike2.getListOfBikeUsers().add(bikeUser);
       bike1.getListOfBikeUsers().add(bikeUser1);
       bike2.getListOfBikeUsers().add(bikeUser1);

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(bike1);  // We need to persist Bike object explicitly , even though there is a  mapping between Bike and BikeUser
           // session.save(bike2);
            session.persist(bikeUser);
            session.persist(bikeUser1);
            transaction.commit();

            // One to Many mapping creates a third table with id's from both table which maps bikeUser to bike
        }


    }

}
