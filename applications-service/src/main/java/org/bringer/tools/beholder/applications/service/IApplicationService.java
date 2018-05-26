package org.bringer.tools.beholder.applications.service;

import java.util.List;

import org.bringer.tools.beholder.applications.model.Application;

public interface IApplicationService {
	
	public void add(Application app);
	public List<Application> findAll();
	public List<Application> findByName(String name);

}
