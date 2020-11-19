package com.test.tools.springbootuntil.dao;

import com.test.tools.springbootuntil.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

//@Mapper
public interface testDao {
    /**
     * 增删改方法
     *
     * @return
     * @author gwj
     * @date 2020/11/5
     */
    /**
     * 查询全部用户
     * @return
     */
    List<User> selectAll();

    /**
     * 分页查询用户
     * @return
     */
    //@Select("select id,name,age,sex from sys_user")
    List<User> selectPage();
}

