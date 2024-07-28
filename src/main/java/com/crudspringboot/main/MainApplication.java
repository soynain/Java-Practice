package com.crudspringboot.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class MainApplication implements ApplicationListener<ContextRefreshedEvent>{

	 static Logger logger 
        = LoggerFactory.getLogger(MainApplication.class); 
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);

		
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		logger.info("HOLA MUNDO SOY MOISEXY Y ESTA ES MI PRIMERA PRUEBA");
	}

}
