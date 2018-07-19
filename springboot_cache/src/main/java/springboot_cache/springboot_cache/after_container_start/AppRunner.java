package springboot_cache.springboot_cache.after_container_start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springboot_cache.springboot_cache.dao.BookDao;

@Component
/**
 * The AppRunner implements CommandLineRunner , this will be executed after the spring IOC container start
 *
 * Just like this:
 *
 * 2018-07-10 14:16:10.058  INFO 25293 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
   2018-07-10 14:16:10.076  INFO 25293 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
   2018-07-10 14:16:10.096  INFO 25293 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
   2018-07-10 14:16:10.099  INFO 25293 --- [  restartedMain] s.s.SpringbootCacheApplication           : Started SpringbootCacheApplication in 2.254 seconds (JVM running for 3.016)
   2018-07-10 14:16:10.101  INFO 25293 --- [  restartedMain] s.s.after_container_start.AppRunner      : ....Fetching Books...
   2018-07-10 14:16:13.105  INFO 25293 --- [  restartedMain] s.s.after_container_start.AppRunner      : isbn-1234 -->Book [ ISBN=isbn-1234, TITLE=Love]
   2018-07-10 14:16:16.106  INFO 25293 --- [  restartedMain] s.s.after_container_start.AppRunner      : isbn-5678 -->Book [ ISBN=isbn-5678, TITLE=Love]
   2018-07-10 14:16:16.108  INFO 25293 --- [  restartedMain] s.s.after_container_start.AppRunner      : isbn-1234 -->Book [ ISBN=isbn-1234, TITLE=Love]
   2018-07-10 14:16:16.109  INFO 25293 --- [  restartedMain] s.s.after_container_start.AppRunner      : isbn-5678 -->Book [ ISBN=isbn-5678, TITLE=Love]
   2018-07-10 14:16:16.109  INFO 25293 --- [  restartedMain] s.s.after_container_start.AppRunner      : isbn-1234 -->Book [ ISBN=isbn-1234, TITLE=Love]
   2018-07-10 14:16:16.109  INFO 25293 --- [  restartedMain] s.s.after_container_start.AppRunner      : isbn-5678 -->Book [ ISBN=isbn-5678, TITLE=Love]

 */


public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

//    @Autowired
//    BookDao bookDao;

    private final BookDao bookDao;

    public AppRunner(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("....Fetching Books...");

        logger.info("isbn-1234 -->" + bookDao.getByIsbn("isbn-1234"));
        logger.info("isbn-5678 -->" + bookDao.getByIsbn("isbn-5678"));

        logger.info("isbn-1234 -->" + bookDao.getByIsbn("isbn-1234"));
        logger.info("isbn-5678 -->" + bookDao.getByIsbn("isbn-5678"));

        logger.info("isbn-1234 -->" + bookDao.getByIsbn("isbn-1234"));
        logger.info("isbn-5678 -->" + bookDao.getByIsbn("isbn-5678"));

    }
}
