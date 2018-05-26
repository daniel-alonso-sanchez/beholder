package org.bringer.tools.beholder.applications.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bringer.tools.beholder.applications.model.Application;
import org.bringer.tools.beholder.applications.service.BaseApplicationTest;
import org.bringer.tools.beholder.applications.service.IApplicationService;
import org.bringer.tools.beholder.applications.test.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@Category(UnitTest.class)
@RunWith(MockitoJUnitRunner.class)
public class ApplicationControllerUTest extends BaseApplicationTest {
	@Mock
	private IApplicationService service;
	@InjectMocks
	private ApplicationController controller;
	@Test
	public void should_CallAdd_WhenCallingWithRightData() {		
		
		service.add(new Application());
		verify(service, times(1)).add(any(Application.class));	
	}
	@Test
	public void should_ReturnAll_WhenCallingWithRightData() {		
		when(service.findAll()).thenReturn(Arrays.asList(new Application[] {generateDefaultApplication()}));
		List<Application> apps=controller.findAll();
		verify(service, times(1)).findAll();	
		
		assertNotNull(apps);
		assertEquals(1, apps.size());
	}
	@Test
	public void should_ReturnElement_WhenAskingForName() {		
		when(service.findByName(any(String.class))).thenAnswer(new Answer<List<Application>>() {
			@Override
			public List<Application> answer(InvocationOnMock invocation) throws Throwable {
				String appName=invocation.getArgumentAt(0, String.class);
				List<Application> apps=new ArrayList<>();
				apps.add(generateApplication(appName, appName));
				return apps;
			}
			
		});
		List<Application> apps=controller.findByName("mine");
		verify(service, times(1)).findByName(any(String.class));	
		
		assertNotNull(apps);
		assertEquals(1, apps.size());
	}
	@Test
	public void should_ReturnNone_WhenAskingForWrongName() {		
		when(service.findByName(any(String.class))).thenAnswer(new Answer<List<Application>>() {
			@Override
			public List<Application> answer(InvocationOnMock invocation) throws Throwable {				
				List<Application> apps=new ArrayList<>();				
				return apps;
			}
			
		});
		List<Application> apps=controller.findByName("mine");
		verify(service, times(1)).findByName(any(String.class));	
		
		assertNotNull(apps);
		assertEquals(0, apps.size());
	}
}
