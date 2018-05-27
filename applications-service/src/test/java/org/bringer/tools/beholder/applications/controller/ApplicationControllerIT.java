package org.bringer.tools.beholder.applications.controller;

import static io.restassured.RestAssured.given;

import org.bringer.tools.beholder.applications.ApplicationsServiceApplication;
import org.bringer.tools.beholder.applications.service.BaseApplicationTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationsServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


public class ApplicationControllerIT extends BaseApplicationTest{
	@LocalServerPort
	private int port;

	@Before
	public void setUp() {
		RestAssured.port = port;
	}

	@Test
	public void shouldReturnZeroValues_WhenCalled_WithoutData() throws InterruptedException {
		given().
			basePath("/applications").
		when().
			get("").
		then().
			statusCode(200);
	}
	@Test
	public void shouldReturnOneElement_WhenCalled_WithData() throws InterruptedException {
		given().
			basePath("/applications").
			accept(ContentType.JSON).
			contentType(ContentType.JSON).
			body(generateDefaultApplication()).
			log().all().
			filter(new RequestLoggingFilter()).
			filter(new ResponseLoggingFilter()).
		when().
			put("").
		then().
			statusCode(200);
		
		given().
			basePath("/applications").
			pathParam("name", DEFAULT_NAME).
			log().all().
			filter(new RequestLoggingFilter()).
			filter(new ResponseLoggingFilter()).
		when().
			get("/{name}").
		then().
			statusCode(200).		
			and().
			assertThat().
				body("size",org.hamcrest.Matchers.greaterThan(0));
	}
}
