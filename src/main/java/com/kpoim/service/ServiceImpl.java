package com.kpoim.service;

import com.kpoim.dao.Dao;
import com.kpoim.entity.EntitiesConfiguration;
import com.kpoim.entity.Entity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@org.springframework.stereotype.Service
@Transactional
public class ServiceImpl<T extends Entity> implements Service<T> {

  @Autowired
  Dao dao;

  @Override
  public List<T> findAll(String entityName) {
	return dao.findAll(EntitiesConfiguration.getClassesMap().get(entityName));
  }

  @Override
  public void deleteById(Integer id, String entityName) {
	dao.deleteById(id, EntitiesConfiguration.getClassesMap().get(entityName));
  }

  @Override
  public void saveOrUpdate(T t) {
	dao.saveOrUpdate(t);
  }
  
  @Override
  public Entity findById(Integer id, String entityName){
	return dao.findById(id, EntitiesConfiguration.getClassesMap().get(entityName));
  }
}
