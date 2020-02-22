package com.gd.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2020/1/20.
 */
@ApiModel(value = "人")
public class Person {
    @ApiModelProperty("人的id")
    private Integer id;
    @ApiModelProperty(value="人的姓名")
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }
}
