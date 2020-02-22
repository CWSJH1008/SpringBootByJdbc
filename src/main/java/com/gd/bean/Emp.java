package com.gd.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2020/1/29.
 */
@ApiModel(value = "员工类")
public class Emp {
    @ApiModelProperty("员工ID")
    private Integer id;
    @ApiModelProperty("员工姓名")
    private String emp_name;
    @ApiModelProperty("部门")
    private Depart depart;

    public Emp() {
    }

    public Emp(Integer id, String emp_name, Depart depart) {
        this.id = id;
        this.emp_name = emp_name;
        this.depart = depart;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", emp_name='" + emp_name + '\'' +
                ", depart=" + depart +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public Depart getDepart() {
        return depart;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }
}
