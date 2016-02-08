package com.arbrash.ssh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Arbrash on 2016/2/6.
 */
public class BaseDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

}
