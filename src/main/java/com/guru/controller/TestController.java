package com.guru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController("/test")
public class TestController {
	
	@GetMapping("/v")
	public String echo() {
		return "TEST CONTROLLER";
	}
	
	@ApiOperation(hidden = true, value = "Just an echo message ")
	@GetMapping("/v1")
	public String echo1(@RequestParam String ip) {
		return "WELCOME ::  "+ ip;
	}
}
