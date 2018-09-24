package com.crm.service;

import com.crm.domain.User;

/**
 * @author LGCN
 */
public interface UserService {
    /**
     * 用户登陆。
     *
     * @return
     */
    User islogin(User user) throws Exception;

    /**
     * 用户注册。
     * @param user
     * @throws Exception
     */
    void register(User user) throws Exception;
}
