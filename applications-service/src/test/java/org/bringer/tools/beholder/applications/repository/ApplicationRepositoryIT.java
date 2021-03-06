package org.bringer.tools.beholder.applications.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.bringer.tools.beholder.applications.model.Application;
import org.bringer.tools.beholder.applications.test.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
@Category({IntegrationTest.class})
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@TestPropertySource(locations = "classpath:application.yml")
public class ApplicationRepositoryIT {
	@Autowired
	private ApplicationRepository appRepository;
	@Test
	public void should_AddApplication_WhenCalled() {
		Application app=new Application();
		app.setName("miapp");
		app.setUrl("url");
		app=appRepository.saveAndFlush(app);
		assertNotEquals(null, app.getId());
		assertEquals(1, appRepository.count());
	}

}
