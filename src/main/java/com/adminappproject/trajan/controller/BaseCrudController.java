package com.adminappproject.trajan.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface BaseCrudController<T> {
	public ResponseEntity<T> getById(Long id);
	public ResponseEntity<T> create(T dto, BindingResult result);
	public ResponseEntity<T> update(T dto, Long id);
	public Page<T> getPage(Pageable pageable);
}
