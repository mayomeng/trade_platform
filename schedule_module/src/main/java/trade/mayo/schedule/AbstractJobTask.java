package trade.mayo.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by Administrator on 2017/6/16.
 */
public abstract class AbstractJobTask implements JobTask{

    private JobExecutionContext jobExecutionContext;
    private String name;
    private String group;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        this.jobExecutionContext = jobExecutionContext;
        befordeJob();
        work();
        afterJob();
    }

    public JobExecutionContext getContext() {
        return jobExecutionContext;
    }

    public void befordeJob() {}
    public void afterJob() {}

    public abstract void setName();
    public  abstract void setGroup();
}
