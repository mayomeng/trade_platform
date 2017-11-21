package trade.mayo.schedule;

import org.quartz.Job;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface JobTask extends Job {
    public void work();
    public String getName();
    public String getCronExpression();
}
