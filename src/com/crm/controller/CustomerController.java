package com.crm.controller;

import com.crm.domain.Customer;
import com.crm.domain.User;
import com.crm.domain.pageBean;
import com.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.io.File;
import java.util.List;

/**
 * @author LGCN
 */
public class CustomerController extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();

    /**
     * Action按照名称自动注入service（去容器中栈匹配的名字，注意属性注入需要set方法。）
     */
    private CustomerService customerservice;

    public void setCustomerservice(CustomerService customerservice) {
        this.customerservice = customerservice;
    }

    @Override
    public Customer getModel() {
        return customer;
    }

    /**
     * 去新增页面
     * @return
     * @throws Exception
     */
    public String addUI() {
        return "goadd";
    }

    /**
     * 当前页数。
     * 每一页显示条数。
     */
    private Integer currPage = 1;
    private Integer pageSize = 3;

    public void setCurrPage(Integer currPage) {
        if (currPage == null || currPage < 0){
            currPage = 1;
        }
        this.currPage = currPage;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize < 0  ){
            pageSize  = 3;
        }
        this.pageSize = pageSize;
    }

    /**
     * 分页查询所有客户并跳转显示
     * @return
     * @throws Exception
     */
    public String customerlist() throws Exception {
        //离线查询封装条件。
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        //封装查询条件 客户名称中带某字段的
        if (null != customer){
            if ( null != customer.getCust_name() && !"".equals(customer.getCust_name().trim())){
                detachedCriteria.add(Restrictions.like("cust_name", customer.getCust_name(),MatchMode.ANYWHERE));
            }
            if (null != customer.getBaseDictSource() &&  !"".equals(customer.getBaseDictSource().getDict_id())){
                detachedCriteria.add(Restrictions.eq("baseDictSource.dict_id", customer.getBaseDictSource().getDict_id()));
            }
            if (null != customer.getBaseDictLevel() && !"".equals(customer.getBaseDictLevel().getDict_id())){
                detachedCriteria.add(Restrictions.eq("baseDictLevel.dict_id", customer.getBaseDictLevel().getDict_id()));
            }
            if (null != customer.getBaseDictIndustry() && !"".equals(customer.getBaseDictIndustry().getDict_id())){
                detachedCriteria.add(Restrictions.eq("baseDictIndustry.dict_id", customer.getBaseDictIndustry().getDict_id()));
            }
        }
        //返回分页对象
        pageBean<Customer> customers = customerservice.fandPage(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(customers);
        return "customerlist";
    }



    private String uploadFileName;
    private String uploadContentType;
    private File upload;

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    /**
     * 提交新增 上传文件。
     *  文件上传必须提供三个属性，
     *      1  表单name属性+FileName(上传表单的名字，);
     *      2  表单name属性+ContentType(上传文件的类型);
     *      3  上传的文件 (表单的name属性)
     * 数据字段
     * @return
     */
    public String savecustomer() {

        try {
            customerservice.saveCustomer(customer,uploadFileName,uploadContentType,upload);
            return "submitcustomer";
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError("请您正确填写表单·");
            return "error";
        }
    }

    /**
     * 去修改页面回显数据。
     * @return
     */
    public String updatecustomer() throws Exception {
            Customer showCustomer = customerservice.updateCustoner(customer);
            ValueStack vs = ActionContext.getContext().getValueStack();
            vs.push(showCustomer);
        return "updatecustomer";
    }

    /**
     * 提交修改。
     * @return
     */
    public String submitupdate(){
        try {
            customerservice.submitUpdate(customer,uploadFileName,uploadContentType,upload);
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError("抱歉，修改失败·");
            return "error";
        }
        return "submitcustomer";
    }

    /**
     * 删除客户
     * @return
     */
    public String deletecustomer() throws Exception {
        customerservice.deleteCustomer(customer);
        return "submitcustomer";
    }
}
