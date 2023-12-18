package lk.ijse.dep11.app;

import lk.ijse.dep11.app.db.HibernateUtil;
import org.hibernate.*;

public class HelloHibernate {
    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();

            try {
                System.out.println(session);
                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                throw t;
            } finally {
                session.close();
                sf.close();
            }
        }
    }
}
