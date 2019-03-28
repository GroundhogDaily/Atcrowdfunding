package com.atguigu.atcrowdfunding.manager.service;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.util.Page;

import java.util.Map;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈用户Serverr〉
 *
 * @author chen
 * @create 2019/1/14
 */
public interface UserServer {
    /**
     * 登录
     * @param map 传递参数
     * @return user
     */
    User queryUserlogin (Map map);

    /**
     * 用户分页查询
     * @param pageno
     * @param pagesize
     * @return
     */
    //public Page queryPage(Integer pageno,Integer pagesize);

    /**
     * 添加一个用户
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 用户分页查询和模糊查询
     * @param map
     * @return
     */
    Page queryPage(Map<String, Object> map);

    /**
     * 获取指定用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 更新指定用户信息
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 删除单个用户
     * @param id
     * @return
     */
    Integer deleteUser(Integer id);

    /**
     * 删除多个用户
     * @param ids
     * @return
     */
    int deleteUsers(Integer[] ids);

    /**
     * 查询用户角色分配情况
     * @param id
     * @return
     */
    Integer[] queryUserRole(Integer id);
}
