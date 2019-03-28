package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.manager.service.CertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈资质模块〉
 *
 * @author chen
 * @create 2019/3/24
 */
@Controller
@RequestMapping("/cert")
public class CertController {

    @Autowired
    private CertService certService;

    @RequestMapping("/toCert")
    public String toCert(){
        return "/cert/cert";
    }
}
