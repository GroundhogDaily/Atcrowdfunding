package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.manager.service.UserServer;
import com.atguigu.atcrowdfunding.util.AjaxResult;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈首页跳转〉
 *
 * @author chen
 * @create 2019/1/12
 */
@Controller
public class DispatcherController {

    @Autowired
    private UserServer userServer;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){

        session.invalidate();
        return "redirect:/index.htm";
    }
    /**
      结合Jackson组件，将返回结果转为字符串，将json串以流的方式返回客户端
      异步请求
     */
    @ResponseBody
    @RequestMapping("/doLogin")
    public Object dologin(String loginacct, String userpswd, String type, HttpSession session){
        AjaxResult result = new AjaxResult();
        try {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("loginacct",loginacct);
            map.put("userpswd", MD5Util.digest(userpswd));
            map.put("type",type);
            User user = userServer.queryUserlogin(map);
            session.setAttribute(Const.LOGIN_USER,user);
            result.setSuccess(true);
            //{"success" : ture)
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("登录失败");
            e.printStackTrace();
        }
        return result;
    }
//    @RequestMapping("/dologin")
//    public String dologin(String loginacct, String userpswd, String type, HttpSession session){
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("loginacct",loginacct);
//        map.put("userpswd",userpswd);
//        map.put("type",type);
//        User user = userServer.queryUserlogin(map);
//        session.setAttribute(Const.LOGIN_USER,user);
//        return "redirect:/main.htm";
//    }

}
