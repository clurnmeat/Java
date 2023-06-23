package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {
        private SessionFactory hibernateConfig(){
                SessionFactory factory = new org.hibernate.cfg.Configuration().addAnnotatedClass(MovieEntity.class).buildSessionFactory();
                return factory;
        }




}