package org.hibernate.CachePractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class cacheMain {
    public static void main(String[] args) {
        /// Adding data to DB
        CacheTable cacheTable = new CacheTable();
        cacheTable.setName("test details for second level cache");
        CacheTable cacheTable2 = new CacheTable();
        cacheTable2.setName("test 2 ---- details for second level cache");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cacheTable);
        session.save(cacheTable2);
        transaction.commit();
        session.close();

        /// Retrieving data from DB

        Session session1 = sessionFactory.openSession();
        System.err.println("reading from db----");
        CacheTable user1 =session1.get(CacheTable.class,1);
        user1.setName("update the name");
        CacheTable user2 =session1.get(CacheTable.class,1);
        System.out.println(user1.getName());
        session1.close();
        System.err.println("-----------  Second read after session close------------------------------------------");

        Session session2 = sessionFactory.openSession();
        System.err.println("reading from db----");
        CacheTable user3 =session2.get(CacheTable.class,1);
        user1.setName("update the name");
        CacheTable user4 =session2.get(CacheTable.class,1);
        session2.close();

        // Query is not cached even if we use second level cache. It need some additional configs
        System.err.println("Query --");

        Session session3 = sessionFactory.openSession();
        Query query = session3.createQuery("from CacheTable");
        query.setCacheable(true);
        List list = query.list();
        session3.close();

        Session session4 = sessionFactory.openSession();
        Query query2 = session4.createQuery("from CacheTable");
        query2.setCacheable(true);
        List list2 = query2.list();
        session3.close();



    }
}
