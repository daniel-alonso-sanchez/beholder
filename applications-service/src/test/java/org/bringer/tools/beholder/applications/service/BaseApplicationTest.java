package org.bringer.tools.beholder.applications.service;

import org.bringer.tools.beholder.applications.model.Application;

public class BaseApplicationTest {
	protected static final String DEFAULT_NAME = "prueba";
	protected static final String DEFAULT_URL = "http://prueba";
	protected Application generateDefaultApplication(){
		return generateApplication(DEFAULT_NAME, DEFAULT_URL);
	}
	protected Application generateApplication(String name,String url){
		Application app=new Application();
		app.setName(name);
		app.setUrl(url);
		return app;
	}
}
