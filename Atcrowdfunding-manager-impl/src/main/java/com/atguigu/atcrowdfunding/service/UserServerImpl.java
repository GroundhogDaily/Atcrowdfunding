package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.Exception.LoginFailException;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.manager.dao.UserMapper;
import com.atguigu.atcrowdfunding.manager.dao.UserRoleMapper;
import com.atguigu.atcrowdfunding.manager.service.UserServer;
import com.atguigu.atcrowdfunding.util.MD5Util;
import com.atguigu.atcrowdfunding.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈用户实现类〉
 *
 * @author chen
 * @create 2019/1/14
 */
@Service
public class UserServerImpl implements UserServer {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    public User queryUserlogin(Map map) {
        User user = userMapper.queryUserlogin(map);
        if (user == null){
            throw new LoginFailException("用户名或密码不正确");
        }
        return user;
    }

    /*public Page queryPage(Integer pageno, Integer pagesize) {
        Page page = new Page(pageno,pagesize);
        Integer startIndex = page.getStartIndex();
        //查询用户数据
        List datas = userMapper.queryPage(startIndex,pagesize);
        Integer totalsize = userMapper.queryCount();
        //查询总记录数
        page.setDatas(datas);
        page.setTotalsize(totalsize);

        return page;
    }*/

    public int saveUser(User user) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String createtime = simpleDateFormat.format(date);
        user.setCreatetime(createtime);
        user.setUserpswd(MD5Util.digest("123"));
        return userMapper.insert(user);
    }

    public Page queryPage(Map<String, Object> map) {
        Page page = new Page((Integer)map.get("pageno"),(Integer)map.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        map.put("startIndex", startIndex);
        //查询用户数据
        List datas = userMapper.queryPage(map);
        Integer totalsize = userMapper.queryCount(map);
        //查询总记录数
        page.setDatas(datas);
        page.setTotalsize(totalsize);

        return page;
    }

    public User getUserById(Integer id) {

        return userMapper.selectByPrimaryKey(id);
    }

    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    public Integer deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public int deleteUsers(Integer[] ids) {
        int totalCount = 0;
        for (Integer id :
                ids) {
            totalCount += userMapper.deleteByPrimaryKey(id);
        }
        return totalCount;
    }

    public Integer[] queryUserRole(Integer id) {

        Integer[] roleId = userRoleMapper.selectByUserId(id);
        return roleId;
    }
}
