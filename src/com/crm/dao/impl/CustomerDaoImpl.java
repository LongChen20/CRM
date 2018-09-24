package com.crm.dao.impl;

import com.crm.dao.CustomerDao;
import com.crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author LGCN
 */
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {
//    @Override
//    public void save(Customer customer) throws Exception {
//        this.getHibernateTemplate().save(customer);
//    }
//
//    @Override
//    public List<Customer> fandAllcustomer()  {
//       /* DetachedCriteria dc = DetachedCriteria.forClass(Customer.class); QBC 离线查询所有 分页方便
//        List<Customer> customers = (List<Customer>) this.getHibernateTemplate().findByCriteria(dc);*/
//        List<Customer> customers = (List<Customer>) this.getHibernateTemplate().find("from Customer");
//        return customers;
//    }

//    @Override
//    public void delete(Long id) throws Exception {
//        //先查询在删除
//       Customer customer =  this.getHibernateTemplate().get(Customer.class,id);
//        this.getHibernateTemplate().delete(customer);
//    }

    /**
     * 去修改页面回显数据
     * @param customer
     * @return
     * @throws Exception
     */
//    @Override
//    public Customer updateCustomer(Customer customer) throws Exception {
//       Customer customer1 = this.getHibernateTemplate().get(Customer.class, customer.getCust_id());
//        return customer1;
//    }

    /**
     * 提交修改
     */
//    @Override
//    public void update(Customer customer) {
//        this.getHibernateTemplate().update(customer);
//    }


//    @Override
//     public Integer fandCount(DetachedCriteria detachedCriteria) {
//        detachedCriteria.setProjection(Projections.rowCount());
//        List<Long> sum = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
//        if (sum.size() > 0){
//            return sum.get(0).intValue();
//        }
//        return null;
//    }


//    @Override
//    public List<Customer> fandPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
//        //该对象是同一个对象，上面查询完没有清空。
//        detachedCriteria.setProjection(null);
//        //直接调用criteria的分页查询方法传入条件，开始页，每页显示条数。
//        return (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
//    }
}
