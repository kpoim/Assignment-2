package com.kpoim.dao;

import com.kpoim.entity.Entity;
import java.util.List;

public interface Dao<T extends Entity>{
  
  List<T> findAll(Class<T> aClass);
  
  void deleteById(Integer id, Class<T> aClass);
  
  void saveOrUpdate(T t);
  
  Entity findById(Integer id, Class<T> aClass);
//  
//  boolean save(T t);
//  
//  boolean update(T t);
//  
//  boolean delete(T t);

  
}