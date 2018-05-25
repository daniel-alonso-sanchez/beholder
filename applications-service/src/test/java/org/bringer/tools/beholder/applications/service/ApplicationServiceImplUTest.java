package org.bringer.tools.beholder.applications.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.bringer.tools.beholder.applications.model.Application;
import org.bringer.tools.beholder.applications.repository.ApplicationRepository;
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
public class ApplicationServiceImplUTest {
	@Mock
	private ApplicationRepository appRepository;
	@InjectMocks
	private ApplicationServiceImpl service;
	@Test
	public void should_CallSave_WhenCallingWithRightData() {		
		
		when(appRepository.save(any(Application.class))).thenAnswer(new Answer<Application>() {

			@Override
			public Application answer(InvocationOnMock invocation) throws Throwable {
				Application app=invocation.getArgumentAt(0, Application.class);
				app.setId(UUID.randomUUID());
				return app;
			}
		});
		
		service.add(new Application());
		verify(appRepository, times(1)).save(any(Application.class));	
	}

}
