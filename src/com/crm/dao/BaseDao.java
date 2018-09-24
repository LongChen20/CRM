package com.crm.dao;

import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * @author LGCN
 * 通用的DAO
 */
public interface BaseDao<T>  {

    /**
     * 新增客户。
     * @param t
     * @throws Exception
     */
    void save(T t) throws Exception;


    /**
     * 删除客户
     * @param t
     * @throws Exception
     */
    void delete(T t) throws Exception;

    /**
     * 执行修改方法
     * @param t
     * @throws Exception
     */
    void update(T t) throws Exception;

    /**
     * 指定id查询数据。
     * @param id
     * @return
     */
    T findByID( Serializable id);

    /**
     * 查询符合指定条件的总数。
     * @param detachedCriteria
     * @return
     */
    Integer countByKey(DetachedCriteria detachedCriteria);

    /**
     * 分页查询所有
     * @param detachedCriteria
     * @param start
     * @param pagesize
     * @return
     */
    List<T> findAll(DetachedCriteria detachedCriteria,Integer start,Integer pagesize);

    /**
     * 查询所有不带任何条件
     * @return
     */
    List<T> selectAll();
}
