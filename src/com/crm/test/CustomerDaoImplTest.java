package com.crm.test;

import com.crm.dao.CustomerDao;
import com.crm.domain.Customer;
import com.crm.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CustomerDaoImplTest {

    @Resource(name = "customerservice")
    private CustomerService cs;

    @Test
    public void fandAllcustomer() throws Exception {
        List<Customer> customers = cs.fandAllCustomer();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void deletecustomer() throws Exception {
        Customer customer = new Customer();
        customer.setCust_id(19L);
        cs.deleteCustomer(customer);
    }


}
