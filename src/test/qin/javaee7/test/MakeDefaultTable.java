package qin.javaee7.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qin.javaee7.core.hibernate.dao.JavaEE7DAOSupport;
import qin.javaee7.hibernate.domain.JavaEE7PO;

import java.util.List;

public class MakeDefaultTable
{
    @Test
    public void make()
    {
        SessionFactory sessionFactory = (SessionFactory) new
                  ClassPathXmlApplicationContext("applicationContext.xml")
                  .getBean("sessionFactory");
        Session session = sessionFactory.openSession();
    }

    @Test
    public void daoTest()
    {
        JavaEE7DAOSupport j = (JavaEE7DAOSupport) new
                  ClassPathXmlApplicationContext("applicationContext.xml")
                  .getBean("objectDAO7");
        List l = j.loadAll(JavaEE7PO.class);
        Object _debug = 0;
    }
}