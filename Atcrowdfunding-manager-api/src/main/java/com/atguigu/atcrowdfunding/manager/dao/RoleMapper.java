package com.atguigu.atcrowdfunding.manager.dao;

import com.atguigu.atcrowdfunding.bean.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);


    Role selectByPrimaryKey(Integer id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    Integer queryTotal();

    List queryPage(Map<String,Object> map);

    Integer queryCount(Map<String,Object> map);

    List<Role> queryRoleByIds(Integer[] roleId);

    List<Role> queryRoleNotId(Integer[] roleId);
}