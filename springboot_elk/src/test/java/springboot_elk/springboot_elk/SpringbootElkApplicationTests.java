package springboot_elk.springboot_elk;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElkApplicationTests {

	@Test
	public void contextLoads() {
	}

	private static final Logger logger = Logger.getLogger(SpringbootElkApplicationTests.class);

	@Test
	public void testELK() {
		for (int i=0; i<100; i++) {
			logger.info("Output info: Hello Info");
			logger.debug("Output debug: Hello Debug");
			logger.error("Output error: Hello Error");
		}
	}

}
