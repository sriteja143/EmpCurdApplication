package com.guru.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import com.guru.util.Myutil;

class SampleSaticFinalTest {
	private SampleService service = new SampleService();;
	private static String TEJA = "TEJA";
	private static String GURU = "GURU";

	@Test
	void testGetmessage() {
		System.out.println(service);
		MockedStatic<Myutil> mocked = Mockito.mockStatic(Myutil.class);
		System.out.println(mocked.getClass());
		mocked.when(()->Myutil.finalmethod(GURU)).thenReturn(TEJA);
        assertEquals(TEJA, Myutil.finalmethod(GURU));
	}
	
	@Test
	void testGetmessageAct() {
        assertEquals(TEJA, service.getfinalmessage(TEJA));
	}

}
