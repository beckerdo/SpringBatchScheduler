

package hello;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class BasicScheduler {
    private static final Logger log = LoggerFactory.getLogger(BasicScheduler.class);

    // @Autowired
    // private JobLauncher jobLauncher;
    //
    // @Autowired
    // private Job job;

    // @Scheduled(cron = "*/5 * * * * MON-FRI")
    @Scheduled(cron = "*/5 * * * * ?")
    public void run() {
        try {
            final String dateParam = new Date().toString();
            new JobParametersBuilder().addString("date", dateParam).toJobParameters();

            System.out.println(dateParam);
            log.info("BasicScheduler running at " + dateParam);

            // final JobExecution execution = this.jobLauncher.run(this.job,
            // jobParams);
            // log.info("BasicScheduler exit status=" + execution.getStatus());

            log.info("BasicScheduler exiting " + dateParam);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
