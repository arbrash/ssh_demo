package com.arbrash.ssh.service;

import com.arbrash.ssh.dao.EmployeeDao;
import com.arbrash.ssh.entities.EmployeeEntity;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    public boolean nameIsValid(String name){
        return employeeDao.getEmployeeByName(name) == null;
    }

    public void saveOrUpdate(EmployeeEntity employeeEntity){
        employeeDao.saveOrUpdate(employeeEntity);
    }

    public void delete(Integer id){
        employeeDao.delete(id);
    }
    public List<EmployeeEntity> getAll(){
        return employeeDao.getAll();
    }

    public EmployeeEntity get(Integer id) {
        return employeeDao.get(id);
    }
}
