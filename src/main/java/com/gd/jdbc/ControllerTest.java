package com.gd.jdbc;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.gd.bean.Emp;
import com.gd.bean.Person;
import com.gd.bean.Profile;
import com.gd.bean.ReturnMessage;
import com.gd.mapper.DepartMapper;
import com.gd.mapper.EmpMapper;
import com.gd.test.TestSpring;
import com.gd.test.starter.HelloService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/1/20.
 */
@Controller
@Api(tags = "测试接口",description = "测试文档",hidden = true)
public class ControllerTest {
    @Autowired
    private DruidDataSource druidDataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DepartMapper departMapper;
    @Autowired
    EmpMapper empMapper;
    @Autowired
    HelloService helloService;
   /* @Autowired
    Profile profile;123*/
    @Autowired
    private TestSpring testSpring;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private PreparedStatement preparedStatement1;
    private ResultSet resultSet;
    private List<Map<String, Object>> maps;
    private Connection connection1;
    private ArrayList<String> strings;
    private ArrayList<Map<String, Object>> mapArrayList;
    private Emp emp;
    private Map<String, Object> stringObjectMap;
    private String string;
    private Person person;

    @ResponseBody
    @GetMapping("/testController")
    public String helloController() throws SQLException{

        System.out.println(druidDataSource.getClass());
        connection = druidDataSource.getConnection();
        String sql="select * from person";
        //maps = jdbcTemplate.queryForList(sql);
        stringObjectMap = jdbcTemplate.queryForMap(sql);
        string = JSON.toJSONString(stringObjectMap);
        System.out.println(string);
        connection.close();
        return string;

    }
    @ApiOperation("查询人员接口")
    //@ApiImplicitParam(value = "id",name = "人员id")
    @ResponseBody
    @GetMapping("/testDataSource/{id}")
    public ReturnMessage testDataSource(  @PathVariable("id") Integer id) throws Exception{
       // System.out.println(druidDataSource.getClass());
        //connection1 = druidDataSource.getConnection();
        //System.out.println(connection1);

        emp = empMapper.empById(id);
        String returnString=JSON.toJSONString(emp);
        person = new Person(3,"张三");
        ArrayList<Object> list=new ArrayList<>();
        list.add(emp);
        list.add(person);
        String jsonString=JSON.toJSONString(list);
        System.out.println(emp);
        //String test=helloService.sayHello("123123123123");
        //System.out.println(test);
        //System.out.println(profile.getActive());
        ReturnMessage returnMessage=new ReturnMessage();
        returnMessage.setMessage("成功");
        returnMessage.setEmp(emp);
        returnMessage.setPerson(person);
      //  String string=JSON.toJSONString(returnMessage);
        return returnMessage;
    }
    @ApiOperation("测试post得到Person")
    @ResponseBody
    @PostMapping("/rPerson")
    public Person rPerson(){
        Person person =new Person(1,"科比");
        return person;
    }

}/*@ApiImplicitParams({
            @ApiImplicitParam(value = "id",name = "人员id",dataType = "int",paramType = "int")
    })*/
    /*@ApiImplicitParam(value = "id",name = "人员id",dataType = "int",paramType = "int")*/
    /*@ApiResponses({
            @ApiResponse(code = 200, message = "接口返回对象参数"),
            @ApiResponse(code = 401,message = "错误401"),
            @ApiResponse(code = 402,message = "错误402"),
            @ApiResponse(code = 403,message = "错误403"),

    })*/