package com.test.tools.springbootuntil.controller;

import com.test.tools.springbootuntil.service.testService;
import com.test.tools.springbootuntil.untils.JsonResult;
import com.test.tools.springbootuntil.untils.PageRequest;
import com.test.tools.springbootuntil.untils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2020/11/18 16:56
 * @UpdateUser: gwj
 * @UpdateDate: 2020/11/18 16:56
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@RestController
@RequestMapping("user")
public class testController {
    @Autowired
    private testService testservice;

    @RequestMapping("/")
    public JsonResult index(){
        return new JsonResult("请输入正确路径","fail",null);
    }
    @RequestMapping("/getUser")
        public Object findPage(Integer PageNum,Integer PageSize) {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageSize(PageSize);
        pageRequest.setPageNum(PageNum);
        return testservice.findPage(pageRequest);
        }
    @RequestMapping("/getUserByRequestBody")
        public Object findPage(@RequestBody PageRequest pageRequest) {
        return testservice.findPage(pageRequest);
        }
        //return new JsonResult("得到数据","ok",page);
    }

