package com.example.college.service.impl;

import java.io.Serializable;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.college.entity.CollegeEntity;
import com.example.college.exception.CollegeException;
import com.example.college.repository.ICollegeRepository;
import com.example.college.service.ICollegeService;

public class AbstractServiceImpl<R extends ICollegeRepository<E, K>, E extends CollegeEntity<K>, K extends Serializable> implements ICollegeService<E, K> {

	@Autowired
	private R repository;
	
	private Class<E> entityClass;
	
	public AbstractServiceImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}
	
	@Override
	public E create(E e) {
		
		return repository.save(e);
	}
	
	@Override
	public Optional<E> read(K k) {
		
		return repository.findById(k);
	}
	
	@Override
	public Page<E> list(Pageable page) {
		
		return repository.findAll(page);
	}
	
	@Override
	public E update(E e) {
		
		if (e.getId() == null)
			throw new CollegeException("Cannot update. ID not found..");
		
		E s = this.read(e.getId()).get();
		Stream.of(this.entityClass.getMethods()).filter(each -> each.getName().startsWith("get") && each.getDeclaringClass().equals(this.entityClass)).forEach(each -> {
			try {
				Object obj = each.invoke(e);
				this.entityClass.getMethod("s"+each.getName().substring(1), each.getReturnType()).invoke(s, obj);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		return repository.save(s);
	}
	
	@Override
	public void delete(E e) {
		repository.deleteById(e.getId());
	}
	
	@Override
	public void deleteById(K k) {
		repository.deleteById(k);
	}
}
