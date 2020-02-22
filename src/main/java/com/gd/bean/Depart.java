package com.gd.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2020/1/29.
 */
@ApiModel("部门类")
public class Depart {
    @ApiModelProperty("部门ID")
    private  Integer id;
    @ApiModelProperty("部门名称")
    private  String depart_name;

    public Depart(Integer id, String depart_name) {
        this.id = id;
        this.depart_name = depart_name;
    }

    @Override
    public String toString() {
        return "Depart{" +
                "id=" + id +
                ", depart_name='" + depart_name + '\'' +
                '}';
    }

    public Depart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }
}
