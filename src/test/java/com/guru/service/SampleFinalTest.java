package com.guru.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.guru.util.MyFinalUtil;

@SpringBootTest
class SampleFinalTest {
	private SampleService service = new SampleService();;
	private static String TEJA = "TEJA";
	private static String GURU = "GURU";
	
	@Mock
	MyFinalUtil util;
	
	@Test
	void testSendResp() {
		System.out.println(service);
		when(util.sendResp(GURU)).thenReturn(TEJA);
        assertEquals(TEJA, util.sendResp(GURU));
	}
	
}
