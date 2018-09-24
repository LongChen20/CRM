package com.crm.dao.impl;

import com.crm.dao.BaseDiceDao;
import com.crm.domain.BaseDict;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author LGCN
 */
public class BaseDiceDaoImpl extends HibernateDaoSupport implements BaseDiceDao {

    @Override
    public List<BaseDict> fandTypeCode(String key){
        List<BaseDict> baseDicts = ( List<BaseDict>)this.getHibernateTemplate().find("from BaseDict where dict_type_code = ?", key);
        return baseDicts;
    }
}
