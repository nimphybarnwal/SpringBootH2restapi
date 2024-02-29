package com.springboot.h2restapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="tbl_movie")
public class Movie 
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String mname;
private String director;
private Long  rating;

@CreationTimestamp
@Column(name="created_at",nullable=false ,updatable=false)
private Date createdAt;

@CreationTimestamp
@Column(name="updated_at")
private Date updatedAt;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getMname() {
	return mname;
}

public void setMname(String mname) {
	this.mname = mname;
}

public String getDirector() {
	return director;
}

public void setDirector(String director) {
	this.director = director;
}

public Long getRating() {
	return rating;
}

public void setRating(Long rating) {
	this.rating = rating;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

@Override
public String toString() {
	return "Movie [id=" + id + ", mname=" + mname + ", director=" + director + ", rating=" + rating + ", createdAt="
			+ createdAt + ", updatedAt=" + updatedAt + "]";
}


}
