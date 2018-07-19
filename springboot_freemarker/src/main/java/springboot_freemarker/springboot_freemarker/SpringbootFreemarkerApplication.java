package springboot_freemarker.springboot_freemarker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("springboot_freemarker.springboot_freemarker.dao")
public class SpringbootFreemarkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFreemarkerApplication.class, args);

//		SpringApplication application = new SpringApplication();
//		application.run(args);
	}
}
