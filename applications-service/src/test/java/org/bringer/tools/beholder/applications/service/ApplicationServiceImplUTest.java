package org.bringer.tools.beholder.applications.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.bringer.tools.beholder.applications.model.Application;
import org.bringer.tools.beholder.applications.repository.ApplicationRepository;
import org.bringer.tools.beholder.applications.test.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
@Category(UnitTest.class)
@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceImplUTest {
	

	
	@Test
	public void test() {
		ApplicationRepository appRepository = mock(ApplicationRepository.class);
		when(appRepository.save(anyList())).thenReturn(Arrays.asList(new Application[] {new Application()}));
		ApplicationServiceImpl impl=new ApplicationServiceImpl(appRepository);
		impl.add(new Application());
		verify(appRepository,times(1)).save(anyList());
	}

}
