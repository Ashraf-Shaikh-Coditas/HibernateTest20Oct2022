package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory sessionFactory;

    public static SessionFactory getFactory() {
        if(sessionFactory== null) {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory;
    }

    public static void closeFactory() {
        if(sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }
}
