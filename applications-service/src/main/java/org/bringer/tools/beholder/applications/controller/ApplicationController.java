package org.bringer.tools.beholder.applications.controller;

import java.util.List;

import org.bringer.tools.beholder.applications.model.Application;
import org.bringer.tools.beholder.applications.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	private IApplicationService service;
	@Autowired
	public ApplicationController(IApplicationService service) {
		super();
		this.service = service;
	}
	@PutMapping(consumes= {MediaType.APPLICATION_JSON_VALUE})
	public void add(
			@RequestBody
			Application app) {
		service.add(app);
	}
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	
	public List<Application> findAll(){
		return service.findAll();		
	}
	@GetMapping(path="/{name}")	
	public List<Application> findByName(
			@PathVariable("name")
			String name){
		return service.findByName(name);		
	}

}
