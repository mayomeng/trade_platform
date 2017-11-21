package trade.mayo.schedule;

import org.quartz.*;

import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */
public class TradeScheduler {

    private Scheduler scheduler;
    private List<JobTask> jobTaskList;

    public TradeScheduler(Scheduler scheduler, List<JobTask> jobTaskList) {
        this.scheduler = scheduler;
        this.jobTaskList = jobTaskList;
    }

    public void startJob() throws SchedulerException {

        for (JobTask jobTask : jobTaskList) {
            JobDetail jobDetail = JobBuilder.newJob(jobTask.getClass()).withIdentity(jobTask.getName()).build();
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobTask.getCronExpression());
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).forJob(jobTask.getName()).build();
            scheduler.scheduleJob(jobDetail, cronTrigger);
        }
    }
}
