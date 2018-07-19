package springboot_rabbitmq.springboot_rabbitmq.after_spring_start;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import springboot_rabbitmq.springboot_rabbitmq.SpringbootRabbitmqApplication;
import springboot_rabbitmq.springboot_rabbitmq.message.Receiver;

import java.util.concurrent.TimeUnit;

@Component
public class AppRunner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    private final ConfigurableApplicationContext context;

    public AppRunner(Receiver receiver, RabbitTemplate rabbitTemplate,
                     ConfigurableApplicationContext context) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }


    @Override
    public void run(String... args) throws Exception{
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(SpringbootRabbitmqApplication.queueName, "Hello From RabbitMQ");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        context.close();

    }

    /**
     * Sending message...
     * Received <Hello From RabbitMQ>
     */
}
