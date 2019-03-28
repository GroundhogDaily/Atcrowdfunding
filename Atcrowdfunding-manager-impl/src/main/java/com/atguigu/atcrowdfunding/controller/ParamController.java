package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.manager.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈参数模块〉
 *
 * @author chen
 * @create 2019/3/24
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    @Autowired
    private ParamService paramService;

    @RequestMapping("/toParam")
    public String toParam() {
        return "/param/param";
    }
}
