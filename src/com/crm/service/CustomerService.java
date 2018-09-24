package com.crm.service;

import com.crm.domain.Customer;
import com.crm.domain.User;
import com.crm.domain.pageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface CustomerService  {

    /**
     *      新增客户，文件上传
     * @param customer 封装客户信息。
     * @param uploadFileName 文件名
     * @param uploadContentType 文件类型。
     * @param upload 上传的文件
     * @throws Exception
     */
    void saveCustomer(Customer customer, String uploadFileName, String uploadContentType, File upload) throws Exception;

    /**
     * 删除用户
     * @throws Exception
     */
    void deleteCustomer(Customer customer) throws Exception;

    /**
     * 查询所有客户
     * @return
     * @throws Exception
     */
    List<Customer> fandAllCustomer() throws Exception;

    /**
     * 修改客户回显
     * @param customer
     * @return
     */
    Customer updateCustoner(Customer customer)throws Exception;

    /**
     * 提交修改
     * @param customer 封装数据。
     * @param uploadFileName 文件名字。
     * @param uploadContentType 文件类型。
     * @param upload 上传的文件。
     * @throws Exception
     */
    void submitUpdate(Customer customer,String uploadFileName, String uploadContentType, File upload) throws Exception;

    /**
     * 分页查询所有数据。
     * @param detachedCriteria
     * @param currPage
     * @param pageSize
     * @return
     */
    pageBean<Customer> fandPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);
}
