package com.test.tools.springbootuntil.untils;

/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2020/11/18 16:30
 * @UpdateUser: gwj
 * @UpdateDate: 2020/11/18 16:30
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */

import lombok.Data;

import java.util.List;

/**
 * 分页返回结果
 */
@Data
public class PageResult {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private List<?> content;
}
