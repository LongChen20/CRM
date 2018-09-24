package com.crm.dao;

import com.crm.domain.Customer;
import com.crm.domain.Linkman;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @author LGCN
 */
public interface LinkmanDao extends BaseDao<Linkman>  {

    /**
     * 保存所有联系人
     */
//    void save(Linkman linkman) throws Exception;

    /**
     * 分页查询所有用户。
     * @param detachedCriteria 封装查询条件。
     * @param currpage 开始行
     * @param pagesize 每页显示多少条记录
     * @return
     */
//    List<Linkman> fandAll(DetachedCriteria detachedCriteria,Integer currpage,Integer pagesize) throws Exception;


    /**
     * 查询符合条件的总记录数。
     * @param detachedCriteria
     * @return
     */
//    Integer findCount(DetachedCriteria detachedCriteria) throws Exception;

    /**
     * 修改数据回显
     * @param id
     * @return
     */
//    Linkman showLinkman(Long id);

    /**
     * 更新联系人
     * @throws Exception
     */
//    void update(Linkman linkman)throws Exception;

    /**
     * 删除联系人。
     * @throws Exception
     */
//    void delete(Linkman linkman) throws Exception;
}
