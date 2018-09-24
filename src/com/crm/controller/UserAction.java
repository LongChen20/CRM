package com.crm.controller;

import com.crm.domain.User;
import com.crm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

/**
 * @author LGCN
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

    /**
     * 手动注入service
     */
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 模型注入
     */
    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    /**
     * 用户登陆。
     * @return
     */
    public String login(){
        try {
            User loginUser = userService.islogin(user);
            ServletActionContext.getRequest().getSession().setAttribute("loginUser",loginUser);
            return "home";
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError("请管理员登陆·");
            return LOGIN;
        }
    }

    /**
     * 用户注册
     * @return
     */
    public String regist(){
        System.out.println(user);
        try {
            userService.register(user);
            return "register";
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError("业务繁忙，请稍后再试。");
            return ERROR;
        }
    }

    /**
     * 注销
     * @return
     */
    public String outlogin(){
        ServletActionContext.getRequest().getSession().removeAttribute("loginUser");
        return "home";
    }
}
