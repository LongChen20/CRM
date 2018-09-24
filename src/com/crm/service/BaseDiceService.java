package com.crm.service;

import com.crm.domain.BaseDict;

import java.util.List;

/**
 * @author LGCN
 */
public interface BaseDiceService {

    /**
     * 查询数据字典
     * @param basedict
     * @return
     */
    List<BaseDict> findkeyTypeCode(BaseDict basedict) throws Exception;
}
