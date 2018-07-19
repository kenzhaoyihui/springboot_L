package springboot_resttemplate.springboot_resttemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springboot_resttemplate.springboot_resttemplate.entity.Quote;

@SpringBootApplication
public class SpringbootResttemplateApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootResttemplateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootResttemplateApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);

			logger.info(quote.toString());
		};
	}
}
