package com.arbrash.ssh.actions;

import com.arbrash.ssh.entities.EmployeeEntity;
import com.arbrash.ssh.service.DepartmentService;
import com.arbrash.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.StrutsConversionErrorInterceptor;
import org.hibernate.annotations.SourceType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Date;


public class EmployeeActions extends ActionSupport implements RequestAware,
        ModelDriven<EmployeeEntity>, Preparable{

    private static final long serialVersionUID = 1L;

    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public String list(){
        request.put("employees",employeeService.getAll());
        return "list";
    }

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    private InputStream inputStream;

    public InputStream getInputStream(){
        return inputStream;
    }

    public String delete(){
        employeeService.delete(id);
        try {
            inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            try {
                inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        }
        return "ajax-success";
    }

    public String input(){
        request.put("departments", departmentService.getAll());

        return INPUT;
    }

    public void prepareInput(){
        if(id != null){
            model = employeeService.get(id);
        }
    }

    public String save(){
        if(id == null) {
            model.setCreatetime(new Date());
        }
        employeeService.saveOrUpdate(model);
        return SUCCESS;
    }

    public void prepareSave(){
        if(id == null) {
            model = new EmployeeEntity();
        }else{
            model =employeeService.get(id);
        }
    }

    private String name;

    public void setName(String name){
        this.name = name;
    }
    public String validateName() throws UnsupportedEncodingException{
        if(employeeService.nameIsValid(name)){
            inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
        }else{
            inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
        }
        return "ajax-success";
    }

    private Map<String, Object> request;
    @Override
    public void setRequest(Map<String, Object> arg0) {
        this.request = arg0;
    }

    private EmployeeEntity model;
    @Override
    public EmployeeEntity getModel() {
        return model;
    }

    @Override
    public void prepare() throws Exception {}
}

