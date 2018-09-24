package com.crm.dao.impl;

import com.crm.dao.LinkmanDao;
import com.crm.domain.Linkman;

/**
 * @author LGCN
 */
public class LinkmanDaoImpl extends BaseDaoImpl<Linkman> implements LinkmanDao {



//    @Override
//    public void save(Linkman linkman) {
//        this.getHibernateTemplate().save(linkman);
//    }
//
//    @Override
//    public List<Linkman> fandAll(DetachedCriteria detachedCriteria,Integer start,Integer pagesize) {
//        detachedCriteria.setProjection(null);
//        return (List<Linkman>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pagesize);
//
//    }

//    @Override
//    public Integer findCount(DetachedCriteria detachedCriteria) {
//        detachedCriteria.setProjection(Projections.rowCount());
//       List<Long> sum = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
//       if (sum.size() >0){
//           Integer count = sum.get(0).intValue();
//           return count;
//       }
//       return null;
//    }

//    @Override
//    public Linkman showLinkman(Long id) {
//        return (Linkman) this.getHibernateTemplate().get(Linkman.class, id);
//    }

//    @Override
//    public void update(Linkman linkman) throws Exception {
//        this.getHibernateTemplate().update(linkman);
//    }

//    @Override
//    public void delete(Linkman linkman) throws Exception {
//        this.getHibernateTemplate().delete(linkman);
//    }
}
