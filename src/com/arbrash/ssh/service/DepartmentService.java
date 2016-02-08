package com.arbrash.ssh.service;

import com.arbrash.ssh.dao.DepartmentDao;
import com.arbrash.ssh.entities.DepartmentEntity;

import java.util.List;

/**
 * Created by Arbrash on 2016/2/6.
 */
public class DepartmentService {

    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao){
        this.departmentDao = departmentDao;
    }

    public List<DepartmentEntity> getAll(){
        return departmentDao.getAll();
    }
}
