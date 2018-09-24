package com.crm.service;

import com.crm.domain.Linkman;
import com.crm.domain.pageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @author LGCN
 */
public interface LinkmanService {

    /**
     * 保存客户
     */
    void saveLinkman(Linkman linkman) throws Exception;

    /**
     * 查询所有联系人。
     * @return
     */
    pageBean<Linkman>  fandAllLinkman(DetachedCriteria detachedCriteria, int currPage, int pageSeiz) throws Exception;

    /**
     * 回显显示一条数据。
     * @param linkman
     * @return
     * @throws Exception
     */
    Linkman showOneLinkman(Linkman linkman) throws Exception;

    /**
     * 更新联系人。
     * @param linkman
     * @throws Exception
     */
    void updateLinkman(Linkman linkman) throws Exception;

    /**
     * 删除联系人
     * @param linkman
     * @throws Exception
     */
    void deleteLinkman(Linkman linkman) throws Exception;

}
