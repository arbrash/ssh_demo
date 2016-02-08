package com.arbrash.ssh.entities;

/**
 * Created by Arbrash on 2016/1/25.
 */
public class DepartmentEntity {
    private int id;
    private String deptname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (id != that.id) return false;
        if (deptname != null ? !deptname.equals(that.deptname) : that.deptname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (deptname != null ? deptname.hashCode() : 0);
        return result;
    }
}
