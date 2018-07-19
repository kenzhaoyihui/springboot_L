package springboot_async.springboot_async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class SpringbootAsyncApplication extends AsyncConfigurerSupport {

	@Override
	public Executor getAsyncExecutor() {
		//return super.getAsyncExecutor();
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("GithubLookUp-");
		executor.initialize();
		return executor;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAsyncApplication.class, args);
	}
}
