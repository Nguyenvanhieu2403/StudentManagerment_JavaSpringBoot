package com.example.ManagementTeacher.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.ManagementTeacher.entity.faculties;
import com.example.ManagementTeacher.reposity.FacultiesReponsitory;
import com.example.ManagementTeacher.service.FacultiesService;

@Service
public class FacultiesServiceImpl implements FacultiesService {
	private static final Logger logger = LoggerFactory.getLogger(FacultiesServiceImpl.class);
	private FacultiesReponsitory facultiesReponsitory;

	public FacultiesServiceImpl(FacultiesReponsitory facultiesReponsitory) {
		super();
		this.facultiesReponsitory = facultiesReponsitory;
	}

	@Override
	public List<faculties> getAllfacultiess() {
		logger.info("Call Impl");
		return facultiesReponsitory.findAll();
	}

	@Override
	public faculties savefaculties(faculties faculties) {
		return facultiesReponsitory.save(faculties);
	}

	@Override
	public faculties getfacultiesById(Long id) {
		// TODO Auto-generated method stub
		return facultiesReponsitory.findById(id).get();
	}

	@Override
	public faculties updatefaculties(faculties faculties) {
		// TODO Auto-generated method stub
		return facultiesReponsitory.save(faculties);
	}

	@Override
	public void deleteFacultiesById(Long id) {
		// TODO Auto-generated method stub
		facultiesReponsitory.deleteById(id);
	}

}
