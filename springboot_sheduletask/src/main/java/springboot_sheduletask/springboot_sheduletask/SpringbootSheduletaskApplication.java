package springboot_sheduletask.springboot_sheduletask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootSheduletaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSheduletaskApplication.class, args);
	}
}
