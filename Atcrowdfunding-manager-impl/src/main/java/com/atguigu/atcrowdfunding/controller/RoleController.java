package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.manager.service.RoleService;
import com.atguigu.atcrowdfunding.util.AjaxResult;
import com.atguigu.atcrowdfunding.util.Page;
import com.atguigu.atcrowdfunding.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈角色模块〉
 *
 * @author chen
 * @create 2019/3/24
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "role/index";
    }


    @ResponseBody
    @RequestMapping("/index")
    public Object index(@RequestParam(value = "pageno",required = false,defaultValue = "1") Integer pageno,
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
            Page page = roleService.queryPage(map);
            ajaxResult.setSuccess(true);
            ajaxResult.setPage(page);
        }catch (Exception e){
            ajaxResult.setSuccess(false);
            e.printStackTrace();
            ajaxResult.setMessage("查询数据失败");
        }
        return ajaxResult;
    }
}
