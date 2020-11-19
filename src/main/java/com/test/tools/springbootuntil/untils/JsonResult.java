package com.test.tools.springbootuntil.untils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2020/11/18 16:58
 * @UpdateUser: gwj
 * @UpdateDate: 2020/11/18 16:58
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JsonResult {
    //定义属性
    //状态描述
    private String msg;
    //状态
    private String status;
    //数据
    private Object data;


    //成功
    public static JsonResult  ok(Object data){
        return new JsonResult("成功","ok",data);
    }
    //失败
    public static JsonResult fail(){
        return new JsonResult("失败","fail",null);
    }

}
