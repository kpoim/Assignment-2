package com.kpoim.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Map;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@javax.persistence.Entity
@Table(name = "students")
@NamedQueries({
  @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
  @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
  @NamedQuery(name = "Student.deleteById", query = "DELETE FROM Student s WHERE s.id = :id")
})
@AttributeOverride(column = @Column(name = "sid"), name = "id")
public class Student extends Entity implements Serializable {
  
  @Column(name = "sfname")
  private String firstName;
  
  @Column(name = "slname")
  private String lastName;
  
  @Column(name = "sdob")
  private Date dateOfBirth;
  
  @Column(name = "stfees")
  private BigDecimal tuitionFees;

  public Student() {
  }

  public Student(String firstName, String lastName, Date dateOfBirth, BigDecimal tuitionFees) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.tuitionFees = tuitionFees;
  }
  
  public Student(Map<String, Object> map){
	
  }

  public Student(String firstName, String lastName, Date dateOfBirth, BigDecimal tuitionFees, Integer id) {
	super(id);
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.tuitionFees = tuitionFees;
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

  public Date getDateOfBirth() {
	return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
  }

  public BigDecimal getTuitionFees() {
	return tuitionFees;
  }

  public void setTuitionFees(BigDecimal tuitionFees) {
	this.tuitionFees = tuitionFees;
  }

  @Override
  public int hashCode() {
	int hash = 7;
	hash = 47 * hash + Objects.hashCode(this.firstName);
	hash = 47 * hash + Objects.hashCode(this.lastName);
	hash = 47 * hash + Objects.hashCode(this.dateOfBirth);
	hash = 47 * hash + Objects.hashCode(this.tuitionFees);
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
	final Student other = (Student) obj;
	if(!Objects.equals(getId(), other.getId())){
	  return false;
	}
	if (!Objects.equals(this.firstName, other.firstName)) {
	  return false;
	}
	if (!Objects.equals(this.lastName, other.lastName)) {
	  return false;
	}
	if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
	  return false;
	}
	if (!Objects.equals(this.tuitionFees, other.tuitionFees)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "Student{" + "id=" + getId() + "firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", tuitionFees=" + tuitionFees + '}';
  }
  
}
