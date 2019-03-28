package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.bean.Role;
import com.atguigu.atcrowdfunding.manager.dao.RoleMapper;
import com.atguigu.atcrowdfunding.manager.service.RoleService;
import com.atguigu.atcrowdfunding.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈角色业务逻辑实现〉
 *
 * @author chen
 * @create 2019/3/24
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public Page queryPage(Map<String, Object> map) {
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex", startIndex);

        //查询用户数据
        List datas = roleMapper.queryPage(map);
        Integer totalsize = roleMapper.queryCount(map);
        //查询总记录数
        page.setDatas(datas);
        page.setTotalsize(totalsize);

        return page;
    }

    public List queryLRoleById(Integer[] roleId) {
        List<Role> roles = roleMapper.queryRoleByIds(roleId);
        return roles;
    }

    public List queryRoleNotId(Integer[] roleId) {
        List<Role> roles = roleMapper.queryRoleNotId(roleId);
        return roles;
    }

    public List queryAll() {
        return roleMapper.selectAll();
    }
}
