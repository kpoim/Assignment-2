package com.kpoim.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@javax.persistence.Entity
@Table(name = "trainers")
@NamedQueries({
  @NamedQuery(name = "Trainer.findAll", query = "SELECT t FROM Trainer t"),
  @NamedQuery(name = "Trainer.findById", query = "SELECT t FROM Trainer t WHERE t.id = :id"),
  @NamedQuery(name = "Trainer.deleteById", query = "DELETE FROM Trainer t WHERE t.id = :id")
})
@AttributeOverride(name="id", column=@Column(name="tid"))
public class Trainer extends Entity implements Serializable {
  
  @Column(name = "tfname")
  private String firstName;
  
  @Column(name = "tlname")
  private String lastName;
  
  @Column(name = "tsubj")
  private String subject;

  public Trainer() {
  }

  public Trainer(String firstName, String lastName, String subject) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.subject = subject;
  }

  public Trainer(String firstName, String lastName, String subject, Integer id) {
	super(id);
	this.firstName = firstName;
	this.lastName = lastName;
	this.subject = subject;
  }

  public String getFirstName() {
	return firstName;
  }

  public void setFirstName(String firstName) {
	this.firstName = firstName;
  }

  public String getLastName() {
	return lastName;
  }

  public void setLastName(String lastName) {
	this.lastName = lastName;
  }

  public String getSubject() {
	return subject;
  }

  public void setSubject(String subject) {
	this.subject = subject;
  }

  @Override
  public int hashCode() {
	int hash = 3;
	hash = 53 * hash + Objects.hashCode(super.getId());
	hash = 53 * hash + Objects.hashCode(this.firstName);
	hash = 53 * hash + Objects.hashCode(this.lastName);
	hash = 53 * hash + Objects.hashCode(this.subject);
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
	final Trainer other = (Trainer) obj;
	if(!Objects.equals(getId(), other.getId())){
	  return false;
	}
	if (!Objects.equals(this.firstName, other.firstName)) {
	  return false;
	}
	if (!Objects.equals(this.lastName, other.lastName)) {
	  return false;
	}
	if (!Objects.equals(this.subject, other.subject)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "Trainer{" + "id=" + getId() + "firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject + '}';
  }
  
}
