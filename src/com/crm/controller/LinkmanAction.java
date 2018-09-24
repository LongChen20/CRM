package com.crm.controller;


import com.crm.domain.Customer;
import com.crm.domain.Linkman;
import com.crm.domain.pageBean;
import com.crm.service.CustomerService;
import com.crm.service.LinkmanService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author LGCN
 */
public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman> {

    private LinkmanService linkmanService;
    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setLinkmanService(LinkmanService linkmanService) {
        this.linkmanService = linkmanService;
    }

    private Linkman linkman = new Linkman();

    @Override
    public Linkman getModel() {
        return linkman;
    }
    /**
     * 跳转到新增联系人并查询所有客户名字显示。
     * @return
     * @throws Exception
     */
    public String addUI() throws Exception {
        List<Customer> customers = customerService.fandAllCustomer();
        ActionContext.getContext().getValueStack().set("list",customers);
        return "goAddUI";
    }

    /**
     * 新增联系人。
     * @return
     * @throws Exception
     */
    public String saveLinkman() {
        try {
            linkmanService.saveLinkman(linkman);
            return "showlinkmanlist";
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError("请正确填写表单·！");
            return ERROR;
        }
    }


    /**
     * 当前页。
     * 每一页显示多少条。
     * 设置初始值和最低值。
     */
    private int currPage =1;
    private int pageSize =3;

    public void setCurrPage(int currPage) {
        if (currPage ==0 ){
            currPage = 1;
        }
        this.currPage = currPage;
    }

    public void setPageSize(int pageSize) {
        if (pageSize ==0){
            pageSize =3;
        }
        this.pageSize = pageSize;
    }

    /**
     * 查询所有联系人
     * @return
     */
    public String listLinkman() throws Exception {
        System.out.println(linkman);
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Linkman.class);
        if (null != linkman){
            if (null != linkman.getLkm_name() && !"".equals(linkman.getLkm_name().trim())){
                detachedCriteria.add(Restrictions.like("lkm_name", linkman.getLkm_name(),MatchMode.ANYWHERE));
            }
//            if (null != linkman.getLkm_cust_id() && !"".equals(linkman.getLkm_cust_id().getCust_id())){
//                detachedCriteria.add(Restrictions.eq("lkm_cust_id", linkman.getLkm_cust_id()));
//            }
        }
        pageBean<Linkman> linkmans = linkmanService.fandAllLinkman(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(linkmans);
        return "linkmanlist";
    }

    /**
     * 异步加载，不能页面跳转
     */
    public void show() throws Exception {
        System.out.println("fangfa jignashfjksjgdaklgjfdjfads");
        //返回JSON数据,不能跳转页面
        List<Customer> customers = customerService.fandAllCustomer();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"baseDictSource","baseDictIndustry","baseDictLevel","cust_phone","cust_mobile","uploadFile","linkmens"});
        JSONArray jsonArray = JSONArray.fromObject(customers, jsonConfig);
        //返回客户端。
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(jsonArray.toString());
    }

    /**
     * 删除联系人
     * @return
     * @throws Exception
     */
    public String deleteLinkman() throws Exception {
        linkmanService.deleteLinkman(linkman);
        return "showlinkmanlist";
    }

    /**
     * qu修改页面回显数据。
     * @return
     * @throws Exception
     */
    public String updateUI() throws Exception {
        List<Customer> customers = customerService.fandAllCustomer();
        ActionContext.getContext().getValueStack().set("list", customers);
        Linkman show = linkmanService.showOneLinkman(linkman);
        ActionContext.getContext().getValueStack().push(show);
        return "goupdateUI";
    }

    /**
     * 执行修改
     * @return
     * @throws Exception
     */
    public String updateLinkman()  {
        System.out.println(linkman);
        try {
            linkmanService.updateLinkman(linkman);
            return "showlinkmanlist";
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError("请正确填写表单·！");
            return ERROR;
        }
    }
}
