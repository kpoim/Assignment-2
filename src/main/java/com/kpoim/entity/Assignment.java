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
@Table(name = "assignments")
@NamedQueries({
  @NamedQuery(name = "Assignment.findAll", query = "SELECT s FROM Assignment s"),
  @NamedQuery(name = "Assignment.findById", query = "SELECT s FROM Assignment s WHERE s.id = :id"),
  @NamedQuery(name = "Assignment.deleteById", query = "DELETE FROM Assignment s WHERE s.id = :id")
})
@AttributeOverride(column = @Column(name = "aid"), name = "id")
public class Assignment extends Entity implements Serializable {
  
  @Column(name = "atitle")
  private String title;
  
  @Column(name = "adesc")
  private String description;
  
  @Column(name = "asubdate")
  private Date submissionDate;
  
  @Column(name = "aomark")
  private Double oralMark;
  
  @Column(name = "atmark")
  private Double totalMark;

  public Assignment() {
  }

  public Assignment(String title, String description, Date submissionDate, Double oralMark, Double totalMark) {
	this.title = title;
	this.description = description;
	this.submissionDate = submissionDate;
	this.oralMark = oralMark;
	this.totalMark = totalMark;
  }

  public Assignment(String title, String description, Date submissionDate, Double oralMark, Double totalMark, Integer id) {
	super(id);
	this.title = title;
	this.description = description;
	this.submissionDate = submissionDate;
	this.oralMark = oralMark;
	this.totalMark = totalMark;
  }

  public String getTitle() {
	return title;
  }

  public void setTitle(String title) {
	this.title = title;
  }

  public String getDescription() {
	return description;
  }

  public void setDescription(String description) {
	this.description = description;
  }

  public Date getSubmissionDate() {
	return submissionDate;
  }

  public void setSubmissionDate(Date submissionDate) {
	this.submissionDate = submissionDate;
  }

  public Double getOralMark() {
	return oralMark;
  }

  public void setOralMark(Double oralMark) {
	this.oralMark = oralMark;
  }

  public Double getTotalMark() {
	return totalMark;
  }

  public void setTotalMark(Double totalMark) {
	this.totalMark = totalMark;
  }

  @Override
  public int hashCode() {
	int hash = 7;
	hash = 53 * hash + Objects.hashCode(this.title);
	hash = 53 * hash + Objects.hashCode(this.description);
	hash = 53 * hash + Objects.hashCode(this.submissionDate);
	hash = 53 * hash + Objects.hashCode(this.oralMark);
	hash = 53 * hash + Objects.hashCode(this.totalMark);
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
	final Assignment other = (Assignment) obj;
	if (!Objects.equals(this.title, other.title)) {
	  return false;
	}
	if (!Objects.equals(this.description, other.description)) {
	  return false;
	}
	if (!Objects.equals(this.submissionDate, other.submissionDate)) {
	  return false;
	}
	if (!Objects.equals(this.oralMark, other.oralMark)) {
	  return false;
	}
	if (!Objects.equals(this.totalMark, other.totalMark)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "Assignment{" + "title=" + title + ", description=" + description + ", submissionDate=" + submissionDate + ", oralMark=" + oralMark + ", totalMark=" + totalMark + '}';
  }

}
