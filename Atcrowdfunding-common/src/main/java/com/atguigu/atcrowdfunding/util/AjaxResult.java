package com.atguigu.atcrowdfunding.util;

import com.atguigu.atcrowdfunding.bean.Role;

import java.util.List;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈异步请求方式返回的数据〉
 *
 * @author chen
 * @create 2019/1/21
 */
public class AjaxResult {

    private boolean success ;

    private String message;

    private Page page;

    private List<Role> leftrole;

    private List<Role> rightrole;

    public List<Role> getLeftrole() {
        return leftrole;
    }

    public void setLeftrole(List<Role> leftrole) {
        this.leftrole = leftrole;
    }

    public List<Role> getRightrole() {
        return rightrole;
    }

    public void setRightrole(List<Role> rightrole) {
        this.rightrole = rightrole;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
