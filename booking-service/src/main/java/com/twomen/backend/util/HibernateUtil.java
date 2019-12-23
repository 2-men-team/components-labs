package com.twomen.backend.util;

import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.MovieShow;
import com.twomen.backend.entity.Place;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.imageio.spi.ServiceRegistry;
import java.util.Properties;

public class HibernateUtil {
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      Configuration configuration = new Configuration();

      Properties properties = new Properties();

      properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
      properties.put(Environment.URL, "jdbc:mysql://localhost:3306/booking_service?allowPublicKeyRetrieval=true&useSSL=false");
      properties.put(Environment.USER, "root");
      properties.put(Environment.PASS, "root");
      properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
      properties.put(Environment.SHOW_SQL, "true");
      properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
      properties.put(Environment.HBM2DDL_AUTO, "validate");

      configuration.setProperties(properties);

      configuration.addAnnotatedClass(Booking.class);
      configuration.addAnnotatedClass(MovieShow.class);
      configuration.addAnnotatedClass(Place.class);

      StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        .applySettings(configuration.getProperties()).build();

      sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    return sessionFactory;
  }
}
