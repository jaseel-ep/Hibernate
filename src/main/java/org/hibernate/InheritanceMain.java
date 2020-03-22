package org.hibernate;

import org.hibernate.Inheritance.FourWheeler;
import org.hibernate.Inheritance.TwoWheeler;
import org.hibernate.Inheritance.InheritenceVehicle;
import org.hibernate.cfg.Configuration;

public class InheritanceMain {
    public static void main(String[] args) {

         InheritenceVehicle vehicle = new InheritenceVehicle();
         vehicle.setVehicleName("Vehice");

        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setSwingArm("Single side");
        twoWheeler.setVehicleName("KTM SuperDuke 1290");

         FourWheeler fourWheeler = new FourWheeler();
         fourWheeler.setRoofTop("Automatic retractable");
         fourWheeler.setVehicleName("Lamborghini Avantador");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try(Session session = sessionFactory.openSession()){
            final Transaction transaction = session.beginTransaction();
          //  session.save(vehicle);
            session.save(fourWheeler);
            session.save(twoWheeler);
            transaction.commit();

        }
    }
}
