package springboot_data_elasticsearch_query.springboot_data_eleasticsearch_query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring Boot 应用的标识
@SpringBootApplication
public class SpringbootDataEleasticsearchQueryApplication {

	public static void main(String[] args) {

		// 程序启动入口
		// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		SpringApplication.run(SpringbootDataEleasticsearchQueryApplication.class, args);
	}
}
