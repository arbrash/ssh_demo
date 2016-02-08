package com.arbrash.ssh.dao;


import com.arbrash.ssh.entities.EmployeeEntity;

import javax.management.Query;
import java.util.List;

public class EmployeeDao extends BaseDao{

    public void delete(Integer id){
        String hql = "DELETE From EmployeeEntity e WHERE e.id = ?";
        getSession().createQuery(hql).setInteger(0,id).executeUpdate();
    }
    public List<EmployeeEntity> getAll(){
        String hql = "FROM EmployeeEntity e left outer join fetch e.department" +
                " order by e.id asc";
        return getSession().createQuery(hql).list();
    }

    public void saveOrUpdate(EmployeeEntity employeeEntity){
        getSession().saveOrUpdate(employeeEntity);
    }

    public EmployeeEntity getEmployeeByName(String name){
        String hql = "from EmployeeEntity e where e.name = ?";
        return (EmployeeEntity) getSession().createQuery(hql).setString(0, name).uniqueResult();
    }

    public EmployeeEntity get(Integer id){
        return (EmployeeEntity) getSession().get(EmployeeEntity.class, id);
    }
}
