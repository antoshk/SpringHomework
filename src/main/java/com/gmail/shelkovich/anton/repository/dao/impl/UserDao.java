package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.model.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDao extends GenericDaoImpl<User, Long> {
    public UserDao() {
        super(User.class);
    }

    public User getByUsername(String username){
       Query<User> query =  sessionFactory.getCurrentSession().createQuery("FROM User WHERE username = :username");
       query.setParameter("username", username);
       return query.uniqueResult();
    }
}
