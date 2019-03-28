package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.manager.service.RoleService;
import com.atguigu.atcrowdfunding.manager.service.UserServer;
import com.atguigu.atcrowdfunding.util.AjaxResult;
import com.atguigu.atcrowdfunding.util.Page;
import com.atguigu.atcrowdfunding.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈用户管理模块〉
 *
 * @author chen
 * @create 2019/3/12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServer userServer;

    @Autowired
    private RoleService roleService;

    /**
     * 获取要删除的用户信息并回显
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id, Map map){
        User user = userServer.getUserById(id);

        map.put("user",user);
        return "/user/edit";
    }

    @RequestMapping("/toIndex")
    public String toIndex(){

        return "/user/index";
    }

    /**
     * 跳转到用户角色分配界面
     * @return
     */
    @RequestMapping("/toAssignRole")
    public String toAssignRole(Integer id,Map map){

        //根据用户ID查询关联Role的ID
        Integer[] roleId = userServer.queryUserRole(id);
        List leftrole ;
        List rightrole =null;
        if(roleId.length>0){
            //查询与用户关联的Role信息
            rightrole = roleService.queryLRoleById(roleId);
            //查询没有与用户关联的Role信息
            leftrole = roleService.queryRoleNotId(roleId);

        }else {
            leftrole = roleService.queryAll();
        }
        map.put("leftrole", leftrole);
        map.put("rightrole", rightrole);

        return "/user/assignRole";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){

        return "/user/add";
    }


    /**
     * 删除单个用户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteUser")
    public Object deleteUser(Integer id){

        AjaxResult ajaxResult = new AjaxResult();
        if(userServer.deleteUser(id)==1){
            ajaxResult.setSuccess(true);
        }else{
            ajaxResult.setSuccess(false);
        }

        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping("/doDeleteBatch")
    public Object doDeleteBatch(Integer[] id){

        AjaxResult ajaxResult = new AjaxResult();

        if(userServer.deleteUsers(id)==id.length){
            ajaxResult.setSuccess(true);
        }else{
            ajaxResult.setSuccess(false);
        }

        return ajaxResult;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/doUpdate")
    public Object doUpdate(User user){

        AjaxResult ajaxResult = new AjaxResult();
            if(userServer.update(user)==1){
                ajaxResult.setSuccess(true);
            }else{
                ajaxResult.setSuccess(false);
            }

        return ajaxResult;
    }

    /**
     * 将查询和模糊查询集合到一起
     * @param pageno
     * @param pagesize
     * @param queryText
     * @return
     */
    @ResponseBody
    @RequestMapping("/index")
    public Object index(@RequestParam(value = "pageno",required = false , defaultValue = "1") Integer pageno,
                        @RequestParam(value = "pagesize",required = false,defaultValue = "10") Integer pagesize,String queryText){

        AjaxResult ajaxResult = new AjaxResult();
        try {
            Map<String,Object> map = new HashMap<String,Object>(5);
            map.put("pageno", pageno);
            map.put("pagesize", pagesize);
            if (StringUtil.isNotEmpty(queryText)) {
                if (queryText.contains("%")) {
                    queryText = queryText.replaceAll("%", "\\\\%");
                }
                map.put("queryText", queryText);
            }
            Page page = userServer.queryPage(map);
            ajaxResult.setSuccess(true);
            ajaxResult.setPage(page);
        }catch (Exception e){
            ajaxResult.setSuccess(false);
            e.printStackTrace();
            ajaxResult.setMessage("查询数据失败");
        }

        //AjaxResult工具类  会将此类转为json数据
        return ajaxResult;
    }

    /**
     *添加一个用户
     * @param loginacct
     * @param username
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping("/doAdd")
    public Object index(String loginacct,String username,String email){

        AjaxResult ajaxResult = new AjaxResult();
        try {
            User user = new User();
            user.setLoginacct(loginacct);
            user.setUsername(username);
            user.setEmail(email);

            if (userServer.saveUser(user) == 1){
                ajaxResult.setSuccess(true);
            }else {
                ajaxResult.setSuccess(false);
            }
        }catch (Exception e){
            ajaxResult.setSuccess(false);
            e.printStackTrace();
            ajaxResult.setMessage("添加数据失败");
        }

        //AjaxResult工具类  会将此类转为json数据
        return ajaxResult;
    }

    /*@RequestMapping("/index")
    public String index(@RequestParam(value = "pageno",required = false , defaultValue = "1") Integer pageno,
                        @RequestParam(value = "pagesize",required = false,defaultValue = "10") Integer pagesize, Map map){

        Page page = userServer.queryPage(pageno, pagesize);

        map.put("page",page);

        return "/user/index";
    }*/
}
