package com.crm.dao;

import com.crm.domain.BaseDict;

import java.util.List;

/**
 * @author LGCN
 */
public interface BaseDiceDao {

    /**
     * 查询数据字典数据。
     * @param key
     * @return
     * @throws Exception
     */
    public List<BaseDict> fandTypeCode(String key) throws Exception;
}
