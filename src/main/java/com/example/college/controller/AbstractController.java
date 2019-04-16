package com.example.college.controller;

import java.io.Serializable;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.college.entity.CollegeEntity;
import com.example.college.service.ICollegeService;

public class AbstractController<S extends ICollegeService<E, K>, E extends CollegeEntity<K>, K extends Serializable> {

	@Autowired
	private S service;

	@GetMapping
	public ResponseEntity<Page<E>> getAll(Pageable page) {
		if (page == null)
			page = Pageable.unpaged();

		return ResponseEntity.ok(service.list(page));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<E> getById(@PathParam("id") K id) {
		Optional<E> v = service.read(id);
		if (!v.isPresent())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(v.get());
	}

	@PostMapping
	public ResponseEntity<E> save(@RequestBody E e) {
		return ResponseEntity.ok(service.create(e));
	}
	
	@PutMapping
	public ResponseEntity<E> update(@RequestBody E e) {
		return ResponseEntity.ok(service.update(e));
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathParam("id") K id) {
		service.deleteById(id);
	}
}
