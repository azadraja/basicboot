package com.example.college.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.college.entity.CollegeEntity;

public interface ICollegeRepository<E extends CollegeEntity<K>, K extends Serializable> extends CrudRepository<E, K>, PagingAndSortingRepository<E, K>{

}
