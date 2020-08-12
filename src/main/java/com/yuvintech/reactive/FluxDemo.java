package com.yuvintech.reactive;

import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxDemo {

	public static void main(String[] args) {
		
		FluxDemo fd = new FluxDemo();
		
		
	Flux<Flux<String>> courses1 =   fd.coreLibrarie()
									  .map(s -> fd.frameWorks(s))
									  .log();
	
	//courses1.subscribe(course -> log.info(""+course));
		
	 Flux<String> courses2 = 	 fd.coreLibrarie()
							 .flatMap(s -> fd.frameWorks(s))
							 .log();
		  
	 courses2.subscribe(course -> log.info(course));
		
	}
	
	public Flux<String> courses(){
		return coreLibrarie()
						 .flatMap(s -> frameWorks(s))
						 .log();
	}
	
	
	
	public Flux<String> coreLibrarie(){
		return   Flux.just("Java","Java Script");
	}
	
	public Flux<String> frameWorks(String name){
		
		if(name.equals("Java")) {
			return Flux.just("Spring", "Struts", "Vertx");
					
		}
		else {
			return Flux.just("Angular", "REact", "VUE");
					
		}
		
		
	}
	
	
	
	
	
	public Flux<String> flux1(){
		return   Flux.just("a", "b");
	}
	
	
	public Flux<String> flux2(String name){
		
		if(name.equals("a")) {
			return Flux.just("name A1", "name A2");
					
		}
		else {
			return Flux.just("name B1", "name B2");
					
		}
		
	}
	
	
	
	public  Flux<String> createFluxWithMapOperator(){
		//List<String> names = Arrays.asList("SunilManaka", "Harish", "Yuvin", "Raghu", "David", "Bob");
		//names.stream().map(name -> name.toUpperCase());
		return   Flux.just("SunilManaka", "Harish", "Yuvin", "Raghu", "David", "Bob")
				     .map(name -> name.toUpperCase())
				     // .map(String::toUpperCase)
				     .log();	
		
		
	}
	
	public  Flux<String> createFlux(){
		return   Flux.just("SunilManaka", "Harish", "Yuvin", "Raghu", "David", "Bob")
				    .log();	
	}
	
	
	public  Flux<String> createErrorFlux(){
		return   Flux.just("SunilManaka", "Harish", "Yuvin", "Raghu", "David", "Bob")
				.error(new RuntimeException());
	}
	
}
