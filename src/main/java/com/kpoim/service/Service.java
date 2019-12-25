package com.kpoim.service;

import com.kpoim.entity.Entity;
import java.util.List;

public interface Service<T extends Entity> {
 
  List<T> findAll(String entityName);
  
  void deleteById(Integer id, String entityName);
  
  void saveOrUpdate(T t);
  
  Entity findById(Integer id, String entityName);
}
