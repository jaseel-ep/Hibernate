package org.hibernate.HQL;

import org.hibernate.DTO.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPractice {
    public static void main(String[] args) {
        HqlUser hqlUser = new HqlUser();


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        for (int i=1;i<=10;i++){
            hqlUser.setName("user "+i);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(hqlUser);
            transaction.commit();
            session.close();
        }
        // HQL
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from HqlUser");   // Note :Suppose if HqlUser is in another package, we have to provide full package name
        List<HqlUser> result=query.list();
            result.stream().map(user-> user.getName()).forEach(System.err::println);
            session.close();

            // Hql to get only one cloumn
        System.err.println("Hql to get only selected cloumns");
        Session session1 = sessionFactory.openSession();
        Query query1 = session1.createQuery("select name,id from HqlUser where id >5");
        List <Object[]> list1=query1.list();
        for (Object[] objArray: list1){
                String name = (String) objArray[0];
            Integer id = (Integer) objArray[1];
            System.out.println("name= "+name+" Id= "+id);

        }
        session1.close();

        System.err.println("Pagenation with HQL--");
        Session session2 = sessionFactory.openSession();
        Query queryPagenation = session2.createQuery("from HqlUser");
        queryPagenation.setFirstResult(1);
        queryPagenation.setMaxResults(3);
        List <HqlUser>list = queryPagenation.list();
        list.stream().map(user-> user.getName()).forEach(System.err::println);

        System.out.println("---------Normal way ");

        Query query2 = session2.createQuery("select name from HqlUser where id= :idValue");
     //   query2.setInteger("idValue",9);
//        query2.setParameter(0,9);
        query2.setParameter("idValue",4);
        List list2 = query2.list();
        System.out.println(list2.get(0));


        System.out.println("----Named Query");
        Query namedQuery = session2.createNamedQuery("HqlUser.getById");
        namedQuery.setParameter("UserID",6);
        HqlUser hqlUser1 = (HqlUser) (namedQuery.list().get(0));
        System.out.println( hqlUser1.getName());

        System.out.println("----Named Native Query");
        Query namedNativeQuery = session2.createNamedQuery("HqlUser.nativeQuery.getName");
        namedNativeQuery.setParameter("UserId",2);
        String  hqlUser2 = (String) (namedNativeQuery.list().get(0));
        System.out.println("named native query result: "+ hqlUser2);






    }
}
