package com.atguigu.atcrowdfunding.manager.dao;

import com.atguigu.atcrowdfunding.bean.UserRole;
import com.atguigu.atcrowdfunding.vo.Data;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    List<UserRole> selectAll();

    int updateByPrimaryKey(UserRole record);

    Integer[] selectByUserId(Integer userid);

    int saveUserRoleRelationship(@Param("userid") Integer userid,@Param("data") Data data);

    int deleteUserRoleRelationship(@Param("userid") Integer userid,@Param("data") Data data);
}