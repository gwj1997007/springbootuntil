package com.test.tools.springbootuntil.untils;

import com.github.pagehelper.PageInfo;

/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2020/11/18 16:35
 * @UpdateUser: gwj
 * @UpdateDate: 2020/11/18 16:35
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class PageUtils {

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param page
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
