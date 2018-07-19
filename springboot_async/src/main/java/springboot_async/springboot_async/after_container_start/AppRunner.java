package springboot_async.springboot_async.after_container_start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springboot_async.springboot_async.entity.User;
import springboot_async.springboot_async.service.GithubLookUpService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final GithubLookUpService githubLookUpService;

    public AppRunner(GithubLookUpService githubLookUpService) {
        this.githubLookUpService = githubLookUpService;
    }

    @Override
    public void run(String... args) throws InterruptedException, ExecutionException {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        Future<User> page1 = githubLookUpService.findUser("kenzhaoyihui");
        Future<User> page2 = githubLookUpService.findUser("Spring-projects");
        Future<User> page3 = githubLookUpService.findUser("Kubernetes");

        // Wait until they are all done
        while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
            Thread.sleep(10);
        }

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis()-start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());
    }
}
