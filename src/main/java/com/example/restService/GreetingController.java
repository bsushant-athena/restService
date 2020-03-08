package com.example.restService;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public com.example.restService.Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new com.example.restService.Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}