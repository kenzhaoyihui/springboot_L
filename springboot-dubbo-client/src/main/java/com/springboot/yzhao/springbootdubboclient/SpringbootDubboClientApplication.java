package com.springboot.yzhao.springbootdubboclient;

import com.springboot.yzhao.springbootdubboclient.dubbo.CityDubboConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootDubboClientApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringbootDubboClientApplication.class, args);

		CityDubboConsumerService cityDubboConsumerService = context.getBean(CityDubboConsumerService.class);

		cityDubboConsumerService.printCity("Nanjing");
		//SpringApplication.run(SpringbootDubboClientApplication.class, args);
	}
}
