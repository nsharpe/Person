package org.neil.person.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import javax.persistence.EntityManagerFactory;

/**
 * Created by neilsharpe on 1/1/16.
 */
@Configuration
public class HibernateConfiguration {

  @Bean
  public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
    HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
    factory.setEntityManagerFactory(emf);
    return factory;
  }
}
