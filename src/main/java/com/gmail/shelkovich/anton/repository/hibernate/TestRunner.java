package com.gmail.shelkovich.anton.repository.hibernate;

import com.gmail.shelkovich.anton.repository.dao.impl.UserDao;
import org.hibernate.Session;

public class TestRunner {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        UserDao userDao = new UserDao(){{this.sessionFactory = HibernateUtils.getSessionFactory();}};
    }
}
