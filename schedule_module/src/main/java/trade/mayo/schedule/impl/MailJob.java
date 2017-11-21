package trade.mayo.schedule.impl;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import trade.mayo.schedule.AbstractJobTask;

/**
 * Created by Administrator on 2017/6/16.
 */
@DisallowConcurrentExecution
@Slf4j
public class MailJob extends AbstractJobTask {
    @Override
    public void work() {
        log.debug("get the mail job time." );
    }

    @Override
    public String getName() {
        return "mailJob";
    }

    @Override
    public String getCronExpression() {
        return "0/10 * * * * ?";
    }

    @Override
    public void setName() {

    }

    @Override
    public void setGroup() {

    }
}
