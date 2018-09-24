package com.crm.service.impl;

import com.crm.Utils.UploadUtil;
import com.crm.dao.CustomerDao;
import com.crm.domain.Customer;
import com.crm.domain.User;
import com.crm.domain.pageBean;
import com.crm.service.CustomerService;
import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author LGCN
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void saveCustomer(Customer customer, String uploadFileName, String uploadContentType, File upload) throws Exception {
        //3 封装到customer中存储到数据库。
        if (null == customer || ("".equals(customer.getCust_name().trim()))) {
            throw new Exception();
        } else {
            //文件上传，
            //1判断文件是否为空
            if (upload != null && upload.length()>0){
                //服务器保存的地址。
                String psth = "E:/upload/";
                //目录分离，
                String path2 = UploadUtil.pathName(uploadFileName);
                String fileURL = psth + path2;
                //创建文件夹。
                File file = new File(fileURL);
                //判断此路径是否存在。
                if (!file.exists()){
                    //不存在则创建。
                    file.mkdirs();
                }
                //获得唯一文件名。
                String filename = UploadUtil.uniqueFileName(uploadFileName);
                //保存文件。保存的地址，文件名字，绝地路径。
                File saveFile = new File(fileURL+"/"+filename);
                //调用struts2提供的工具类。入参1源文件(上传的文件)，2目标文件(服务器保存的绝对路径)。
                FileUtils.copyFile(upload,saveFile);
                //封装到对象中。
                customer.setUploadFile(fileURL+"/"+filename);
                //保存到数据库
                customerDao.save(customer);
            }else{
                customerDao.save(customer);
            }
        }
    }

    @Override
    public void deleteCustomer(Customer customer) throws Exception {
        customerDao.delete(customer);
    }

    @Override
    public List<Customer> fandAllCustomer() throws Exception {
        return customerDao.selectAll();
    }

    /**
     * 回显数据
     *
     * @param customer
     * @return
     * @throws Exception
     */
    @Override
    public Customer updateCustoner(Customer customer) throws Exception {
        return customerDao.findByID(customer.getCust_id());
    }

    /**
     * 提交修改
     *
     * @param customer
     * @throws Exception
     */
    @Override
    public void submitUpdate(Customer customer,String uploadFileName, String uploadContentType, File upload) throws Exception {
        if (null == customer || ("".equals(customer.getCust_name().trim()))) {
            throw new Exception();
        } else {
            //判断上床的文件是否为空
            if (null != upload){
                //获得隐藏字段的值。
                String path = customer.getUploadFile();
                //判断是否为空，不为空删除原有文件，保存新文件。
                if (null != path || !"".equals(path)){
                  File isfile = new File(path);
                    if (isfile.exists()){
                        isfile.delete();
                    }
                }
                    //保存新文件。
                //服务器保存的地址。
                String psth = "E:/upload/";
                //目录分离，
                String path2 = UploadUtil.pathName(uploadFileName);
                String fileURL = psth + path2;
                //创建文件夹。
                File file = new File(fileURL);
                //判断此路径是否存在。
                if (!file.exists()){
                    //不存在则创建。
                    file.mkdirs();
                }
                //获得唯一文件名。
                String filename = UploadUtil.uniqueFileName(uploadFileName);
                //保存文件。保存的地址，文件名字，绝地路径。
                File saveFile = new File(fileURL+"/"+filename);
                //调用struts2提供的工具类。入参1源文件(上传的文件)，2目标文件(服务器保存的绝对路径)。
                FileUtils.copyFile(upload,saveFile);
                //封装到对象中。
                customer.setUploadFile(fileURL+"/"+filename);
                customerDao.update(customer);
            }
                customerDao.update(customer);

        }
    }

    @Override
    public pageBean<Customer> fandPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        pageBean pageBean = new pageBean();
        //封装单钱页。
        pageBean.setCurrPage(currPage);
        //封装每页显示条数。
        pageBean.setPageSize(pageSize);

        //封装总记录。传入离线条件，
        Integer totalcount = customerDao.countByKey(detachedCriteria);
        pageBean.setTotalCount(totalcount);

        //封装总页数。首页Math对象的向上取整方法。总记录/每页显示条数。
        Double tc = totalcount.doubleValue();
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());

        //封装到集合中。 计数开始数据。
        Integer begin = (currPage - 1) * pageSize;
        List<Customer> list = customerDao.findAll(detachedCriteria,begin,pageSize);
        pageBean.setRowPage(list);
        return pageBean;
    }


}
