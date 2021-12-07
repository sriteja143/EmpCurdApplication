package com.guru.service;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import com.guru.util.Myutil;

public class SampleServiceTest {

	private SampleService service = new SampleService();;
	

	@Test
	void testGetmessage() {
		MockedStatic<Myutil> mocked = Mockito.mockStatic(Myutil.class);
		System.out.println(mocked.getClass());
		System.out.println(service);
		
	}

}
