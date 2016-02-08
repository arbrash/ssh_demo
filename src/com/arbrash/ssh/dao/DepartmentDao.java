package com.arbrash.ssh.dao;

import com.arbrash.ssh.entities.DepartmentEntity;

import java.util.List;

/**
 * Created by Arbrash on 2016/2/6.
 */
public class DepartmentDao extends BaseDao{

    public List<DepartmentEntity> getAll(){
        String hql = "FROM DepartmentEntity ";
        return getSession().createQuery(hql).list();
    }
}
