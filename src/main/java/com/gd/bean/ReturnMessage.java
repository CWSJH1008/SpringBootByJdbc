package com.gd.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2020/2/2.
 */
@ApiModel("返回信息")
public class ReturnMessage {
    @ApiModelProperty("返回信息")
    private String message;
    @ApiModelProperty("员工信息")
    private Emp emp;
    @ApiModelProperty("返回人信息")
    private Person person;

    @Override
    public String toString() {
        return "ReturnMessage{" +
                "message='" + message + '\'' +
                ", emp=" + emp +
                ", person=" + person +
                '}';
    }

    public ReturnMessage() {
    }

    public ReturnMessage(String message, Emp emp, Person person) {
        this.message = message;
        this.emp = emp;
        this.person = person;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
