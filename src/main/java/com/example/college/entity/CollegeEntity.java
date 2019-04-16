package com.example.college.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

import lombok.Data;

@Data
@MappedSuperclass
public class CollegeEntity<T> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private T id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", nullable = false)
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt", nullable = false)
	private Date updatedAt;
	
	@PrePersist
	private void onCreate() {
		createdAt = updatedAt = new Date();
	}
	
	@PreUpdate
	private void onUpdate() {
		updatedAt = new Date();
	}
}
