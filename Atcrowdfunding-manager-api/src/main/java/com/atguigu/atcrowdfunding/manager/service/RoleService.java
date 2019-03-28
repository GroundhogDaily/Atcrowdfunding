package com.atguigu.atcrowdfunding.manager.service;

import com.atguigu.atcrowdfunding.util.Page;

import java.util.List;
import java.util.Map;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈角色模块〉
 *
 * @author chen
 * @create 2019/3/24
 */
public interface RoleService {
    Page queryPage(Map<String, Object> map);

    List queryLRoleById(Integer[] roleId);

    List queryRoleNotId(Integer[] roleId);

    List queryAll();
}
