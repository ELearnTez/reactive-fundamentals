package com.yuvintech.reactive;

import java.util.Random;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@Slf4j
public class MonoTest {
	

	
	@Test
	public void testSimpleMono() {
		Mono<String> mono = new MonoDemo().createAMono().log();
		StepVerifier
		      .create(mono)
		      .expectSubscription()
		      .expectNext("So much exisited .... My First Mono")
		      .expectComplete()
		      .verify();
	}
	
	@Test
	public void testSimpleErrorMono() {
		Mono<String> mono = new MonoDemo().createAErrorMono().log();
		StepVerifier
		      .create(mono)
		      .expectSubscription()
		      .expectError(RuntimeException.class)
		      .verify();
	}
	
	
	
}
