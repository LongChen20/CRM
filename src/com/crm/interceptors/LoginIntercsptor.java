package com.crm.interceptors;

import com.crm.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class LoginIntercsptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //获得session中的用户。
        HttpSession session = ServletActionContext.getRequest().getSession();
        //获得当前Action.
        ActionSupport as = (ActionSupport) actionInvocation.getAction();
        User user = (User) session.getAttribute("loginUser");
        if (user != null){
            //session中有用户放行，执行下一个拦截器。
            return actionInvocation.invoke();
        }else {
            as.addActionError("请管理员登陆·");
            return "error";
        }
    }
}
