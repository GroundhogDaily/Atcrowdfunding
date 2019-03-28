package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.manager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈项目管理模块〉
 *
 * @author chen
 * @create 2019/3/24
 */
@Controller
@RequestMapping("/projecttype")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping("/toProject_type")
    public String toProject_type() {
        return "/projecttype/project_type";
    }
}
