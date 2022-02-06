package com.example.belong_app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BelongAppApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testIndexContent() {

		ResponseEntity<String> response = this.restTemplate.getForEntity("/", String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertTrue(response.getBody().contains("Welcome!"));
	}

	@Test
	public void testListPhoneNumbersContent() {

		ResponseEntity<String> response = this.restTemplate.getForEntity("/listPhoneNumbers", String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertTrue(response.getBody().contains("All phone numbers"));
	}

	@Test
	public void testGetCustomerByIdContent() {

		ResponseEntity<String> response = this.restTemplate.getForEntity("/findUser?id=1", String.class );
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertTrue(response.getBody().contains("User Details"));
	}

}
