package com.guru.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;

public class Myutil {
	public static String notify(String input) {
		return input;
	}
	public static String notifyStr() {
		return "GURU";
	}
	public final static String finalmethod(String msg) {
		return msg;
	}
	
	public static void main(String[] args) {
		/*
		 * String url = "http://localhost:9897/id?id=2"; RestTemplate template = new
		 * RestTemplate();
		 * 
		 * for (int i = 0; i < 200000; i++) { ResponseEntity<String> resp =
		 * template.getForEntity(url, String.class); System.out.println(resp.getBody());
		 * }
		 */
		System.out.println(PathSelectors.regex("[/][t][e][s][t][/][a-zA-Z0-9]*").test("/test/abb"));;
	}
}
