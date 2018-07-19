package library.library.test;

import library.library.service.MyService;
import library.library.service.ServiceConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest("service.message=yzhao")
public class MyServiceTest {

    @Autowired
    private MyService service1;


    @Test
    public void testService() {
        System.out.println(service1.message());
    }

    @Test
    public void contextLoads() {
        assertThat(service1.message()).isNotNull();
        System.out.println(service1.message());
    }

    @SpringBootApplication
    @Import(ServiceConfiguration.class)
    static class TestConfiguration {
    }

}
