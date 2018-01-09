package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static Session getSession(){
        Configuration cof=new Configuration();
        cof.configure();
        SessionFactory sf=cof.buildSessionFactory();
        Session session=sf.openSession();
        return session;
    }
}
