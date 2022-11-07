package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/mytestbd?useSSL=false&allowMultiQueries=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "58941561894651";

    private static Util UTIL;

    private Util() {
    }

    public static Util getUtil() {
        if (UTIL == null) {
            UTIL = new Util();
        }
        return UTIL;
    }

    public SessionFactory getFactory() {
        SessionFactory sessionFactory = null;
        try {
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url", URL);
            prop.setProperty("hibernate.connection.username", USERNAME);
            prop.setProperty("hibernate.connection.password", PASSWORD);
            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
            sessionFactory = new Configuration()
                    .setProperties(prop)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
