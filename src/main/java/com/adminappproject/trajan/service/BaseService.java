package com.adminappproject.trajan.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T> {
	public T getById(Long id);
	public T save(T dto);
	public T update(T dto, Long id);
	public Page<T> getPage(Pageable pageable);
}
