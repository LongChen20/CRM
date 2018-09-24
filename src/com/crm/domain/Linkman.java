package com.crm.domain;


/**
 * @author LGCN
 */
public class Linkman {
    /**
     *  联系人表
     */

    /**
     * lkm_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '联系人编号(主键)',
     */
    private Long lkm_id;
    /**
     * ` varchar(16) DEFAULT NULL COMMENT '联系人姓名',
     */
    private String lkm_name;
    /**
     * lkm_gender` char(1) DEFAULT NULL COMMENT '联系人性别',
     */
    private String lkm_gender;
    /**
     * lkm_phone` varchar(16) DEFAULT NULL COMMENT '联系人办公电话',
     */
    private String lkm_phone;
    /**
     * lkm_mobile` varchar(16) DEFAULT NULL COMMENT '联系人手机',
     */
    private String lkm_mobile;
    /**
     * lkm_email` varchar(64) DEFAULT NULL COMMENT '联系人邮箱',
     */
    private String lkm_email;
    /**
     *lkm_qq` varchar(16) DEFAULT NULL COMMENT '联系人qq',
     */
    private String lkm_qq;
    /**
     * lkm_position` varchar(16) DEFAULT NULL COMMENT '联系人职位',
     */
    private String lkm_position;
    /**
     * lkm_memo` varchar(512) DEFAULT NULL COMMENT '联系人备注',
     */
    private String lkm_memo;
    /**
     *  `lkm_cust_id` bigint(32) NOT NULL COMMENT '客户id',
     *  多个联系人只属于一个客户
     */
    private Customer lkm_cust_id;

    public Customer getLkm_cust_id() {
        return lkm_cust_id;
    }

    public void setLkm_cust_id(Customer lkm_cust_id) {
        this.lkm_cust_id = lkm_cust_id;
    }

    public Long getLkm_id() {
        return lkm_id;
    }

    public void setLkm_id(Long lkm_id) {
        this.lkm_id = lkm_id;
    }

    public String getLkm_name() {
        return lkm_name;
    }

    public void setLkm_name(String lkm_name) {
        this.lkm_name = lkm_name;
    }

    public String getLkm_gender() {
        return lkm_gender;
    }

    public void setLkm_gender(String lkm_gender) {
        this.lkm_gender = lkm_gender;
    }

    public String getLkm_phone() {
        return lkm_phone;
    }

    public void setLkm_phone(String lkm_phone) {
        this.lkm_phone = lkm_phone;
    }

    public String getLkm_mobile() {
        return lkm_mobile;
    }

    public void setLkm_mobile(String lkm_mobile) {
        this.lkm_mobile = lkm_mobile;
    }

    public String getLkm_email() {
        return lkm_email;
    }

    public void setLkm_email(String lkm_email) {
        this.lkm_email = lkm_email;
    }

    public String getLkm_qq() {
        return lkm_qq;
    }

    public void setLkm_qq(String lkm_qq) {
        this.lkm_qq = lkm_qq;
    }

    public String getLkm_position() {
        return lkm_position;
    }

    public void setLkm_position(String lkm_position) {
        this.lkm_position = lkm_position;
    }

    public String getLkm_memo() {
        return lkm_memo;
    }

    public void setLkm_memo(String lkm_memo) {
        this.lkm_memo = lkm_memo;
    }

    @Override
    public String toString() {
        return "Linkman{" +
                "lkm_id=" + lkm_id +
                ", lkm_name='" + lkm_name + '\'' +
                ", lkm_gender='" + lkm_gender + '\'' +
                ", lkm_phone='" + lkm_phone + '\'' +
                ", lkm_mobile='" + lkm_mobile + '\'' +
                ", lkm_email='" + lkm_email + '\'' +
                ", lkm_qq='" + lkm_qq + '\'' +
                ", lkm_position='" + lkm_position + '\'' +
                ", lkm_memo='" + lkm_memo + '\'' +
                ", lkm_cust_id=" + lkm_cust_id +
                '}';
    }
}
