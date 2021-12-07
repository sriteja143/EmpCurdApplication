package com.guru.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SampleRestTemplateTest {
	@Mock
	RestTemplate rtemp;
	
	public static String input= "Welcome Buddy !!!";
	
	@Test
	void testRestTemplate() {
		String url = "http://localhost:8080/";
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> resp = template.getForEntity(url, String.class);
		System.out.println(resp.getBody());
		assertEquals(input, resp.getBody());
	}
	
	@Test
	void testMockRestTemplate() {
		System.out.println(rtemp);
		String url = "http://localhost:8080/";
		ResponseEntity<String> responce = new ResponseEntity<String>(input, HttpStatus.ACCEPTED);
		Mockito.when(rtemp.getForEntity(url, String.class)).thenReturn(responce);
		ResponseEntity<String> resp = rtemp.getForEntity(url, String.class);
		System.out.println(resp.getBody());
		assertEquals(input, resp.getBody());
	}

}
