package com.crm.service.impl;

import com.crm.Utils.MD5Utils;
import com.crm.dao.UserDao;
import com.crm.domain.User;
import com.crm.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LGCN
 */
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User islogin(User user) throws Exception {
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        List<User> users = userDao.fandOneUser(user);
        if (users.size() < 0){
            throw new Exception();
        }else {
            return users.get(0);
        }
    }

    @Override
    public void register(User user) throws Exception {
        try {
            user.setUser_password(MD5Utils.md5(user.getUser_password()));
            user.setUser_state("1");
            userDao.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}
