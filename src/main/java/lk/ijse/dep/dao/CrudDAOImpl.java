package lk.ijse.dep.dao;

import lk.ijse.dep.entity.SuperEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class CrudDAOImpl<T extends SuperEntity,ID extends Serializable> implements CrudDAO<T,ID> {
    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> entity;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected CrudDAOImpl(){
        entity = (Class<T>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getSession().createQuery("FROM " + entity.getName()).list();
    }

    @Override
    public T find(ID pk) throws Exception {
        return (T) getSession().get(entity,pk);
    }

    @Override
    public void save(T entity) throws Exception {
        getSession().save(entity);
    }

    @Override
    public void update(T entity) throws Exception {
        getSession().update(entity);
    }

    @Override
    public void delete(ID pk) throws Exception {
        getSession().delete(getSession().load(entity,pk));
    }

}
