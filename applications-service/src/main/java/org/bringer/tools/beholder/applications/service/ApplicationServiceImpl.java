package org.bringer.tools.beholder.applications.service;

import java.util.List;

import org.bringer.tools.beholder.applications.model.Application;
import org.bringer.tools.beholder.applications.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicationServiceImpl implements IApplicationService {
	private ApplicationRepository appRepository;

	@Autowired
	public ApplicationServiceImpl(ApplicationRepository appRepository) {
		super();
		this.appRepository = appRepository;
	}

	@Override
	@Transactional
	public void add(Application app) {
		this.appRepository.save(app);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Application> findAll() {
		
		return this.appRepository.findAll();
	}
	@Transactional(readOnly=true)
	@Override
	public List<Application> findByName(String name) {
	
		return this.appRepository.findByName(name);
	}

}
