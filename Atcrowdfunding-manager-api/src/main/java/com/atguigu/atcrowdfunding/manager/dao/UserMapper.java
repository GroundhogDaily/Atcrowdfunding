package com.atguigu.atcrowdfunding.manager.dao;

import com.atguigu.atcrowdfunding.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

	User queryUserlogin(Map<String, Object> paramMap);

	//List queryPage(@Param("startIndex") Integer startIndex,@Param("pagesize") Integer pagesize);

    //Integer queryCount();

    List queryPage(Map<String,Object> map);

    Integer queryCount(Map<String, Object> map);
}