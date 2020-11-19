package com.test.tools.springbootuntil.untils;

/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2020/11/18 16:29
 * @UpdateUser: gwj
 * @UpdateDate: 2020/11/18 16:29
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */

import lombok.Data;

/**
 * 分页请求
 */
@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
}
