package com.gd.mapper;

import com.gd.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2020/1/29.
 */
@Mapper
public interface EmpMapper {
    List<Emp> empByDepart();
    Emp empById(Integer id);
}
