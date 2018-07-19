package application.application;

import library.library.service.MyService;
import library.library.service.ServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Import(ServiceConfiguration.class)
@RestController
public class Application {

	private final MyService myService;

	@Autowired
	public Application(MyService myService) {
		this.myService = myService;
	}

	@GetMapping(value = "/service")
	public String serviceHome() {
		return myService.message();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
