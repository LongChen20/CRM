package com.crm.dao;

import com.crm.domain.Customer;
import com.crm.domain.User;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @author LGCN
 */
public interface CustomerDao extends BaseDao<Customer> {

    /**
     * 增加客户。
     * @throws Exception
     */
//    void save(Customer customer) throws Exception;

    /**
     * 查询所有的客户。
     * @return 封住数据
     * @throws Exception
     */
//    List<Customer> fandAllcustomer()throws Exception;

    /**
     * 删除客户
     * @throws Exception
     */
//    void delete(Long id) throws Exception;

    /**
     * 修改客户信息 回显
     * @param customer
     * @throws Exception
     */
//    Customer updateCustomer(Customer customer) throws Exception;

    /**
     * 提交修改。
     */
//    void update(Customer customer)throws Exception;


    /**
     * 待条件查询分页数据。
     * @param detachedCriteria
     * @param begin
     * @param pageSize
     * @return
     */
//    List<Customer> fandPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

    /**
     * 查询总记录输
     * @param detachedCriteria
     * @return
     */
//    Integer fandCount(DetachedCriteria detachedCriteria);
}
