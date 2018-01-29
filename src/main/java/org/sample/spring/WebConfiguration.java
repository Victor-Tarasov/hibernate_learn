package org.sample.spring;

import org.h2.server.web.WebServlet;
import org.hibernate.Session;
import org.sample.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Configuration
public class WebConfiguration {
    @Bean
    ServletRegistrationBean h2ServletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

    @Autowired
    WebConfiguration _this;


    @PostConstruct
    public void init() {
        _this.b();
    }

    @Transactional
    public void b() {
        emf.unwrap(Session.class).save("ddd", new Employee());
        System.out.println();
    }

    @PersistenceContext
    private EntityManager emf;
}
