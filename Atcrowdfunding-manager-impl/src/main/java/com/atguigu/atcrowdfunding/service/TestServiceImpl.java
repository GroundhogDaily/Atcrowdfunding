package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.manager.dao.TestDao;
import com.atguigu.atcrowdfunding.manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
/**
 * Demo class
 *
 * @author chen
 * @date 2019/1/12
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    public void insert() {
        Map map = new HashMap();
        System.out.print("hallo");
        map.put("name","张三");
        testDao.insert(map);
        System.out.print("haha");
    }
}
