package com.test.tools.springbootuntil.pojo;

import lombok.Data;

/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2020/11/18 16:21
 * @UpdateUser: gwj
 * @UpdateDate: 2020/11/18 16:21
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Data
public class User {
    //id
    private Integer id;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //性别
    private String sex;
}
