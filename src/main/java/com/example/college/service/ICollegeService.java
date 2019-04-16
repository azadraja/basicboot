package com.example.college.service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.college.entity.CollegeEntity;

public interface ICollegeService<E extends CollegeEntity<K>, K extends Serializable> {

	E create(E e);

	Optional<E> read(K k);

	Page<E> list(Pageable page);

	E update(E e);

	void delete(E e);

	void deleteById(K k);
}
