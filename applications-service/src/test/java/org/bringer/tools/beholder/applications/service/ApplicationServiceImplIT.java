package org.bringer.tools.beholder.applications.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.bringer.tools.beholder.applications.model.Application;
import org.bringer.tools.beholder.applications.test.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@Category({ IntegrationTest.class })
@RunWith(SpringRunner.class)
@SpringBootTest(classes= {ApplicationServiceImpl.class})
@TestPropertySource(locations = "classpath:application.yml")
@EnableJpaRepositories(basePackages="org.bringer.tools.beholder.applications.repository")
@EntityScan(basePackages="org.bringer.tools.beholder.applications.model")
@EnableAutoConfiguration
public class ApplicationServiceImplIT extends BaseApplicationTest{
	@Autowired
	private IApplicationService service;
	
	@Test
	public void should_AddApplication_WhenFilleWithRightData() {
		service.add(generateDefaultApplication());
		List<Application>apps=service.findByName(DEFAULT_NAME);
		assertNotNull(apps);	
		assertNotEquals(0,apps.size());
		assertEquals(DEFAULT_NAME, apps.get(0).getName());
	}

}
