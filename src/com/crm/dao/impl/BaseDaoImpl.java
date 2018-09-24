package com.crm.dao.impl;

import com.crm.dao.BaseDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author LGCN
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private  Class lazz;

    public BaseDaoImpl(Class clazz) {
        //方法一 子类必须重写父类的有参构造，在构造中传入具体的Class
        this.lazz = clazz;
    }

    public BaseDaoImpl() {
        /**
         * 方法二，反射获得泛型的实际类型参数。
         *  Type[] getGenericInterfaces() 接口可以多实现。
         *           返回表示某些接口的 Type，这些接口由此对象所表示的类或接口直接实现。
         *  Type getGenericSuperclass()  Java只能单继承
         *           返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
         */
        //1 获得调用者的类类型。
        Class clzz = this.getClass();
        //2通过类类型获得参数化类型。
        Type stype = clzz.getGenericSuperclass();
        //3强转成其子接口。(该接口中有获得实际类型参数的方法。)
        ParameterizedType ptype = (ParameterizedType)stype;
        //4调用 Type[] getActualTypeArguments()  返回表示此类型实际类型参数的 Type 对象的数组,Map<String,Object>,List<Integer>。
        Type[] types = ptype.getActualTypeArguments();
        if (types.length > 0){
            this.lazz  = (Class) types[0];
        }
    }

    @Override
    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public T findByID(Serializable id) {
        return (T) this.getHibernateTemplate().get(lazz, id);
    }

    @Override
    public Integer countByKey(DetachedCriteria detachedCriteria) {
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> count = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if (count.size() > 0){
            return count.get(0).intValue();
        }
        return null;
    }

    @Override
    public List<T> findAll(DetachedCriteria detachedCriteria, Integer start, Integer pagesize) {
        detachedCriteria.setProjection(null);
        return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, start, pagesize);
    }

    @Override
    public List<T> selectAll() {
        return (List<T>) this.getHibernateTemplate().find("from   "+lazz.getSimpleName());
    }


}
