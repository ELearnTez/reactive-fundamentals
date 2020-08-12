package com.yuvintech.reactive;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@Slf4j
public class FluxTest {
	
	
	
	@Test
	public void testSimpleFlux() {
		
		FluxDemo fluxDemo = new FluxDemo();
		
		Flux<String> flux = fluxDemo.createFlux().log();
		
		StepVerifier
		       .create(flux)
		       .expectSubscription()
		       .expectNext("SunilManaka", "Harish", "Yuvin", "Raghu", "David", "Bob")
		       .expectComplete()
		       .verify();
		
		
	}

	@Test
	public void testSimpleErrorFlux() {
		
		FluxDemo fluxDemo = new FluxDemo();
		
		Flux<String> flux = fluxDemo.createErrorFlux().log();
		
		StepVerifier
		       .create(flux)
		       .expectSubscription()
		        .expectError()
		       .verify();
	}
	
	
	
	@Test
	public void testSimpleFluxWithMap() {
		FluxDemo fluxDemo = new FluxDemo();
		Flux<String> flux = fluxDemo.createFluxWithMapOperator().log();
		StepVerifier
		       .create(flux)
		       .expectSubscription()
		       .expectNext("SUNILMANAKA", "HARISH", "YUVIN", "RAGHU", "DAVID", "BOB")
		       .expectComplete()
		       .verify();
		}
	
	
	@Test
	public void testSimpleFluxWithFlatMap() {
		FluxDemo fluxDemo = new FluxDemo();
		
		Flux<String> courses =  fluxDemo.courses();
		
		StepVerifier
		       .create(courses)
		       .expectSubscription()
		       .expectNext("Spring", "Struts", "Vertx", "Angular", "REact", "VUE")
		       .expectComplete()
		       .verify();
		}


	
}
