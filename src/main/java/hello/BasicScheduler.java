

package hello;

import java.util.Date;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class BasicScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Scheduled(cron = "*/5 * * * * MON-FRI")
    public void run() {
        try {
            final String dateParam = new Date().toString();
            final JobParameters param =
                    new JobParametersBuilder().addString("date", dateParam).toJobParameters();

            System.out.println(dateParam);

            final JobExecution execution = this.jobLauncher.run(this.job, param);
            System.out.println("Exit Status : " + execution.getStatus());
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
