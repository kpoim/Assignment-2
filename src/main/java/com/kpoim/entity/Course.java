package com.kpoim.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@javax.persistence.Entity
@Table(name = "courses")
@NamedQueries({
  @NamedQuery(name = "Course.findAll", query = "SELECT s FROM Course s"),
  @NamedQuery(name = "Course.findById", query = "SELECT s FROM Course s WHERE s.id = :id"),
  @NamedQuery(name = "Course.deleteById", query = "DELETE FROM Course s WHERE s.id = :id")
})
@AttributeOverride(column = @Column(name = "cid"), name = "id")
public class Course extends Entity implements Serializable{
  
  @Column(name = "ctitle")
  private String title;
  
  @Column(name = "cstream")
  private String stream;
  
  @Column(name = "ctype")
  private String type;
  
  @Column(name = "csdate")
  private Date startDate;
  
  @Column(name = "cedate")
  private Date endDate;

  public Course() {
  }

  public Course(String title, String stream, String type, Date startDate, Date endDate) {
	this.title = title;
	this.stream = stream;
	this.type = type;
	this.startDate = startDate;
	this.endDate = endDate;
  }

  public Course(String title, String stream, String type, Date startDate, Date endDate, Integer id) {
	super(id);
	this.title = title;
	this.stream = stream;
	this.type = type;
	this.startDate = startDate;
	this.endDate = endDate;
  }

  public String getTitle() {
	return title;
  }

  public void setTitle(String title) {
	this.title = title;
  }

  public String getStream() {
	return stream;
  }

  public void setStream(String stream) {
	this.stream = stream;
  }

  public String getType() {
	return type;
  }

  public void setType(String type) {
	this.type = type;
  }

  public Date getStartDate() {
	return startDate;
  }

  public void setStartDate(Date startDate) {
	this.startDate = startDate;
  }

  public Date getEndDate() {
	return endDate;
  }

  public void setEndDate(Date endDate) {
	this.endDate = endDate;
  }

  @Override
  public int hashCode() {
	int hash = 7;
	hash = 31 * hash + Objects.hashCode(this.title);
	hash = 31 * hash + Objects.hashCode(this.stream);
	hash = 31 * hash + Objects.hashCode(this.type);
	hash = 31 * hash + Objects.hashCode(this.startDate);
	hash = 31 * hash + Objects.hashCode(this.endDate);
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
	final Course other = (Course) obj;
	if (!Objects.equals(this.title, other.title)) {
	  return false;
	}
	if (!Objects.equals(this.stream, other.stream)) {
	  return false;
	}
	if (!Objects.equals(this.type, other.type)) {
	  return false;
	}
	if (!Objects.equals(this.startDate, other.startDate)) {
	  return false;
	}
	if (!Objects.equals(this.endDate, other.endDate)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "Course{" + "title=" + title + ", stream=" + stream + ", type=" + type + ", startDate=" + startDate + ", endDate=" + endDate + '}';
  }
  
}
