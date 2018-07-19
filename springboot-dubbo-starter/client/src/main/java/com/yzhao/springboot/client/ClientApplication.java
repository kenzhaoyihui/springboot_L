package com.yzhao.springboot.client;

import com.yzhao.springboot.client.service.EchoClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ClientApplication.class, args);

		EchoClientService echoClientService = context.getBean(EchoClientService.class);

		System.out.println(echoClientService.echoService.echo("hello, yzhao"));
		//SpringApplication.run(ClientApplication.class, args);
	}
}
