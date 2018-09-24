package com.crm.dao;

import com.crm.domain.User;

import java.util.List;

/**
 * @author LGCN
 */
public interface UserDao {

    /**
     * 用户登陆。
     * @return
     * @throws Exception
     */
    List<User> fandOneUser(User user) throws Exception;

    /**
     * 管理员注册。。
     * @param user
     * @throws Exception
     */
    void saveUser(User user) throws Exception;
}
