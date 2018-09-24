package com.crm.dao.impl;

import com.crm.dao.UserDao;
import com.crm.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author LGCN
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public List<User> fandOneUser(User user) throws Exception {
        List<User> users = (List<User>) this.getHibernateTemplate().find("from User where user_name = ? and user_password = ?", user.getUser_name(), user.getUser_password());
        return users;
    }

    @Override
    public void saveUser(User user) throws Exception {
        this.getHibernateTemplate().save(user);
    }
}
