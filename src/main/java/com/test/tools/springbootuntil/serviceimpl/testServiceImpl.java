package com.test.tools.springbootuntil.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.tools.springbootuntil.dao.testDao;
import com.test.tools.springbootuntil.pojo.User;
import com.test.tools.springbootuntil.service.testService;
import com.test.tools.springbootuntil.untils.PageRequest;
import com.test.tools.springbootuntil.untils.PageResult;
import com.test.tools.springbootuntil.untils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2020/11/18 16:18
 * @UpdateUser: gwj
 * @UpdateDate: 2020/11/18 16:18
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Service
public class testServiceImpl implements testService {
    @Resource
    private testDao testdao;
    /**
     * 调用分页插件完成分页
     * @param -pageQuery
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     * @param -pageQuery
     * @return
     */
    private PageInfo<User> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<User> sysMenus = testdao.selectPage();
        return new PageInfo<User>(sysMenus);
    }
}
