package org.bringer.tools.beholder.applications.service;

import java.util.List;

import org.bringer.tools.beholder.applications.model.Application;
import org.bringer.tools.beholder.applications.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicationServiceImpl implements IApplicationService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private ApplicationRepository appRepository;

	@Autowired
	public ApplicationServiceImpl(ApplicationRepository appRepository) {
		super();
		this.appRepository = appRepository;
	}

	@Override
	@Transactional
	public void add(Application app) {
		this.appRepository.saveAndFlush(app);	
	}

	@Override
	@Transactional(readOnly=true)
	public List<Application> findAll() {
		log.info("Total elements: {}",this.appRepository.count());
		return this.appRepository.findAll();
	}
	@Transactional(readOnly=true)
	@Override
	public List<Application> findByName(String name) {
		log.info("Total elements: {}",this.appRepository.count());
		List<Application>apps=this.appRepository.findByName(name);
		log.info("Total elements with name {}: {}",name,apps.size());
		return this.appRepository.findByName(name);
	}

}
