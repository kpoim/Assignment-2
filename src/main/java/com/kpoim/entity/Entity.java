package com.kpoim.entity;

import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Entity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  public Entity() {
  }

  public Entity(Integer id) {
	this.id = id;
  }

  public Integer getId() {
	return id;
  }

  public void setId(Integer id) {
	this.id = id;
  }

  @Override
  public int hashCode() {
	int hash = 7;
	hash = 37 * hash + Objects.hashCode(this.id);
	return hash;
  }

  @Override
  public boolean equals(Object obj) {
	if (this == obj) {
	  return true;
	}
	if (obj == null) {
	  return false;
	}
	if (getClass() != obj.getClass()) {
	  return false;
	}
	final Entity other = (Entity) obj;
	if (!Objects.equals(this.id, other.id)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "Entity{" + "id=" + id + '}';
  }
  
}
