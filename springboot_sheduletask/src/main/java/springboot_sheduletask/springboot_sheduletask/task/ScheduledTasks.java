package springboot_sheduletask.springboot_sheduletask.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(fixedRate = 2000)
    //@Scheduled(fixedDelay = 2000)
    //@Scheduled(initialDelay = 1000, fixedRate = 2000)
    //@Scheduled(cron = ) 6 fields
    public void reportCurrentTime() {
        logger.info("The time is now {}", dataFormat.format(new Date()));
    }
}
