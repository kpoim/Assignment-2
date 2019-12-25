package com.kpoim.dao;


import com.kpoim.entity.Entity;
import com.kpoim.entity.Trainer;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class DaoImpl<T extends Entity> extends SuperDao implements Dao<T> {

  @Override
  public List<T> findAll(Class<T> aClass) {
	String query = aClass.getSimpleName().concat(".findAll");
	return getSession().createNamedQuery(query, aClass).getResultList();
  }

//  @Override
  public Trainer findById(int id) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void deleteById(Integer id, Class<T> aClass) {
	Query q = getSession().createNamedQuery(aClass.getSimpleName().concat(".deleteById"));
	q.setParameter("id", id);
	q.executeUpdate();
  }

  @Override
  public void saveOrUpdate(T t) {
	getSession().saveOrUpdate(t);
  }

  @Override
  public Entity findById(Integer id, Class<T> aClass) {
	Query q = getSession().createNamedQuery(aClass.getSimpleName().concat(".findById"));
	q.setParameter("id", id);
	return (Entity)q.getSingleResult();
  }
  
  
}
