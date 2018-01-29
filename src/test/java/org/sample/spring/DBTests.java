package org.sample.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DBTests {

    @Autowired
    private EntityManagerFactory emf;
    private Session session;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        startTransaction();
    }

    private void closeTransaction() {
        session.getTransaction().commit();
        session.close();
    }

    private void startTransaction() {
        Session session = makeSession();
        session.getTransaction().begin();
        this.session = session;
    }

    private Session makeSession() {
        return emf.unwrap(SessionFactory.class).openSession();
    }
}
