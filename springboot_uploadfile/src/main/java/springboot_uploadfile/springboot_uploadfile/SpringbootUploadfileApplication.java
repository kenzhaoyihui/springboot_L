package springboot_uploadfile.springboot_uploadfile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import springboot_uploadfile.springboot_uploadfile.storage.StorageProperties;
import springboot_uploadfile.springboot_uploadfile.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties({StorageProperties.class})
public class SpringbootUploadfileApplication {


    public static void main(String[] args) {
		SpringApplication.run(SpringbootUploadfileApplication.class, args);
	}

    // Spring boot 提供 CommandLineRunner 在项目启动后加载一些内容
	@Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
