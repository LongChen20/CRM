package com.crm.service.impl;

import com.crm.dao.LinkmanDao;
import com.crm.dao.impl.BaseDaoImpl;
import com.crm.domain.Linkman;
import com.crm.domain.pageBean;
import com.crm.service.LinkmanService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author LGCN
 */
@Transactional
public class LinkmanServiceImpl implements LinkmanService {

    private LinkmanDao linkmanDao;

    public void setLinkmanDao(LinkmanDao linkmanDao) {
        this.linkmanDao = linkmanDao;
    }

    @Override
    public void saveLinkman(Linkman linkman) throws Exception {
        //去除前后空格
        linkman.setLkm_name(linkman.getLkm_name().trim());
        linkmanDao.save(linkman);
    }

    @Override
    public pageBean<Linkman> fandAllLinkman(DetachedCriteria detachedCriteria, int currPage, int pageSeiz) throws Exception {
        pageBean<Linkman> pagebean = new pageBean<>();
        //封装当前页。
        pagebean.setCurrPage(currPage);
        //封装每页记录数。
        pagebean.setPageSize(pageSeiz);
        // 封装总记录数
        Integer sum = linkmanDao.countByKey(detachedCriteria);
        pagebean.setTotalCount(sum);
        //封装总条数。总记录除以每一页。
        Double s = sum.doubleValue();
        Double totalPage = Math.ceil(s / pageSeiz);
        pagebean.setTotalPage(totalPage.intValue());
        //封装集合。计算开始行。
        Integer start = (currPage -1)*pageSeiz;
        pagebean.setRowPage(linkmanDao.findAll(detachedCriteria,start,pageSeiz));
        return pagebean;
    }

    @Override
    public Linkman showOneLinkman(Linkman linkman) throws Exception {
        Linkman show =  linkmanDao.findByID(linkman.getLkm_id());
        show.setLkm_name(show.getLkm_name().trim());
        return show;
    }

    @Override
    public void updateLinkman(Linkman linkman) throws Exception {
        linkman.setLkm_name(linkman.getLkm_name().trim());
        linkmanDao.update(linkman);
    }

    @Override
    public void deleteLinkman(Linkman linkman) throws Exception {
        linkmanDao.delete(linkman);
    }


}
