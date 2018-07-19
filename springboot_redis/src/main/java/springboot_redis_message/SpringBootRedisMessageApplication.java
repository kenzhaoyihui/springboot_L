package springboot_redis_message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import springboot_redis_message.message.Receiver;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class SpringBootRedisMessageApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootRedisMessageApplication.class);

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
        return container;
    }

    @Bean
    MessageListenerAdapter messageListenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch);
    }

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    public static void main(String[] args) throws Exception{
        //SpringApplication.run(SpringBootRedisMessageApplication.class, args);
        ApplicationContext ctx = SpringApplication.run(SpringBootRedisMessageApplication.class, args);

        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        CountDownLatch latch = ctx.getBean(CountDownLatch.class);

        logger.info("Sending message...");
        template.convertAndSend("chat", "Hello from Redis");

        latch.await();
        System.exit(0);
    }

    /**
     *  2018-07-11 00:20:51.008  INFO 10097 --- [  restartedMain] s.SpringBootRedisMessageApplication      : Started SpringBootRedisMessageApplication in 8.997 seconds (JVM running for 10.192)
     *  2018-07-11 00:20:51.013  INFO 10097 --- [  restartedMain] s.SpringBootRedisMessageApplication      : Sending message...
     *  2018-07-11 00:20:51.031  INFO 10097 --- [    container-2] s.message.Receiver                       : Received <Hello from Redis>
     *  2018-07-11 00:20:51.035  INFO 10097 --- [      Thread-10] ConfigServletWebServerApplicationContext : Closing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@7af35a11: startup date [Wed Jul 11 00:20:43 CST 2018]; root of context hierarchy
     *  2018-07-11 00:20:51.039  INFO 10097 --- [      Thread-10] o.s.c.support.DefaultLifecycleProcessor  : Stopping beans in phase 2147483647
     *  2018-07-11 00:20:51.046  INFO 10097 --- [      Thread-10] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
     *  2018-07-11 00:20:51.047  INFO 10097 --- [      Thread-10] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans
     *  2018-07-11 00:20:52.184  INFO 10097 --- [      Thread-10] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
     *  2018-07-11 00:20:52.185  INFO 10097 --- [      Thread-10] .SchemaDropperImpl$DelayedDropActionImpl : HHH000477: Starting delayed drop of schema as part of SessionFactory shut-down'
     *  2018-07-11 00:20:52.195  WARN 10097 --- [      Thread-10] o.s.b.f.support.DisposableBeanAdapter    : Invocation of destroy method failed on bean with name 'inMemoryDatabaseShutdownExecutor': org.h2.jdbc.JdbcSQLException: Database is already closed (to disable automatic closing at VM shutdown, add ";DB_CLOSE_ON_EXIT=FALSE" to the db URL) [90121-197]
     *  2018-07-11 00:20:52.196  INFO 10097 --- [      Thread-10] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
     *  2018-07-11 00:20:52.204  INFO 10097 --- [      Thread-10] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

     Process finished with exit code 0

     */
}
