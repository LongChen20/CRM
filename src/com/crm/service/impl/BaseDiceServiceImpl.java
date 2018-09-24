package com.crm.service.impl;

import com.crm.dao.BaseDiceDao;
import com.crm.domain.BaseDict;
import com.crm.service.BaseDiceService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LGCN
 */
@Transactional
public class BaseDiceServiceImpl implements BaseDiceService {

    private BaseDiceDao baseDiceDao;

    public void setBaseDiceDao(BaseDiceDao baseDiceDao) {
        this.baseDiceDao = baseDiceDao;
    }

    @Override
    public List<BaseDict> findkeyTypeCode(BaseDict basedict) throws Exception {
        return baseDiceDao.fandTypeCode(basedict.getDict_type_code());
    }
}
