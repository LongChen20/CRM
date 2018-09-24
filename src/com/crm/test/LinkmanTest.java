package com.crm.test;

import com.crm.domain.Customer;
import com.crm.domain.Linkman;
import com.crm.service.CustomerService;
import com.crm.service.LinkmanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class LinkmanTest {

    @Resource(name = "linkmanService")
    private LinkmanService linkmanService;

    @Resource(name = "customerservice")
    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public LinkmanService getLinkmanService() {
        return linkmanService;
    }

    @Test
    public void testLinkman() throws Exception {

        Customer customer = new Customer();
        customer.setCust_id(15L);
        Linkman linkman = new Linkman();
        linkman.setLkm_name("从嗷嗷");
        linkman.setLkm_cust_id(customer);
        linkmanService.saveLinkman(linkman);

    }

    @Test
    public void testcustomerall() throws Exception {
        List<Customer> customers = customerService.fandAllCustomer();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
