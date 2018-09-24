package com.crm.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LGCN
 */
public class Customer {

    /**
     * 客户表。
     */
    private Long cust_id;
    /**
     * 客户名称(公司名称)
     */
    private String cust_name;
    /**
     * 客户信息来源
     *   String cust_source;
     */
   private BaseDict baseDictSource;

    /**
     * 客户所属行业
     *   String cust_industry;
     */
    private BaseDict baseDictIndustry;
    /**
     * 客户级别
     *  String cust_level;
     */
    private BaseDict baseDictLevel;
    /**
     * 固定电话
     */
    private String cust_phone;
    /**
     * 移动电话
     */
    private String cust_mobile;

    /**
     * 上传的文件
     */
    private String uploadFile;

    /**
     * 映射关系配置，一个客户对应多个联系人。
     */
    private Set<Linkman> linkmens = new HashSet<>();

    public Set<Linkman> getLinkmens() {
        return linkmens;
    }

    public void setLinkmens(Set<Linkman> linkmens) {
        this.linkmens = linkmens;
    }

    public String getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(String uploadFile) {
        this.uploadFile = uploadFile;
    }

    public BaseDict getBaseDictSource() {
        return baseDictSource;
    }

    public void setBaseDictSource(BaseDict baseDictSource) {
        this.baseDictSource = baseDictSource;
    }

    public BaseDict getBaseDictIndustry() {
        return baseDictIndustry;
    }

    public void setBaseDictIndustry(BaseDict baseDictIndustry) {
        this.baseDictIndustry = baseDictIndustry;
    }

    public BaseDict getBaseDictLevel() {
        return baseDictLevel;
    }

    public void setBaseDictLevel(BaseDict baseDictLevel) {
        this.baseDictLevel = baseDictLevel;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", baseDictSource=" + baseDictSource +
                ", baseDictIndustry=" + baseDictIndustry +
                ", baseDictLevel=" + baseDictLevel +
                ", cust_phone='" + cust_phone + '\'' +
                ", cust_mobile='" + cust_mobile + '\'' +
                '}';
    }
}
