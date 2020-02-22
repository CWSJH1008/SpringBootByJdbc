package com.gd.mapper;

import com.gd.bean.Depart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2020/1/29.
 */
@Mapper
public interface DepartMapper {
    Depart departById();
}
