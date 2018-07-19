package springboot_redis_message.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import springboot_redis_message.SpringBootRedisMessageApplication;
import springboot_redis_message.dao.RedisDao;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringBootRedisMessageApplication.class})
@SpringBootTest
public class SpringBootRedisMessageApplicationTest {

    public static final Logger logger = LoggerFactory.getLogger(SpringBootRedisMessageApplicationTest.class);

    @Autowired
    RedisDao redisDao;

    @Test
    public void testRedis() {
        redisDao.setKey("name", "zyh");
        redisDao.setKey("age", "23");

        logger.info(redisDao.getValue("name"));

        logger.info(redisDao.getValue("age"));
    }
}
