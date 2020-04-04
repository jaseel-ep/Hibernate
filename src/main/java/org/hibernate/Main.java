package org.hibernate;

import org.hibernate.DTO.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.jnlp.UnavailableServiceException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

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

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query= session.createQuery("select userName,userID from org.hibernate.DTO.UserDetails");
        List<Object[]> list = query.list();
        Object[] o = list.get(0);
        String string = (String) o[0];
        Integer id = (Integer) o[1];
        System.out.println(string);
        System.out.println(id);
        session.close();
        //  list.stream().forEach(user ->System.err.println(user));

        // Criteria API

        Session sess = sessionFactory.openSession();
        Criteria criteria = sess.createCriteria(UserDetails.class);
        criteria.add(Restrictions.eq("userID",1));
        List list1 = criteria.list();
        UserDetails userDet=(UserDetails)list1.get(0);
        System.err.println("------------------------ CRITERIA API");
        System.out.println(userDet.getUserName());
        sess.close();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UserDetails");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDetails> criteria1 = criteriaBuilder.createQuery(UserDetails.class);
        Root<UserDetails> root = criteria1.from(UserDetails.class);
        criteria1.select(root);

    }

}
