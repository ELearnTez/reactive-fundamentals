package com.yuvintech.reactive;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
public class MonoDemo {
	
	public static void main(String[] args) {
		
		MonoDemo md = new MonoDemo();
		
		String rawData = md.createAMono().block();
		
		System.out.println(rawData);
		
		
	}

	
	public  Mono<String> createAMono(){
		return Mono.just("So much exisited .... My First Mono");
	}
	
	
	public  Mono<String> createAErrorMono(){
		return Mono.error(new RuntimeException("This error MOno"));
	}
	
	
	
	
}
