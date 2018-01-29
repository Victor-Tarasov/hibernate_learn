package org.sample.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DBTests {

    @Autowired
    private EntityManagerFactory emf;
    private Session session;
    private EntityManager entityManager;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        startTransaction();
        Employee firstEmployee = new Employee();
        entityManager.merge(firstEmployee);
        Employee secondEmployee = new Employee().setId(1L);
        Employee mergeResult = entityManager.merge(secondEmployee);
        commitTransaction();
    }

    private void commitTransaction() {
        session.getTransaction().commit();
        session.close();
    }

    private void startTransaction() {
        makeSession();
        session.getTransaction().begin();
    }

    private void makeSession() {
        this.entityManager = emf.createEntityManager();
        this.session = entityManager.unwrap(Session.class);
    }
}
