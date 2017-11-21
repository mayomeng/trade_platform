package trade.mayo.schedule;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Created by Administrator on 2017/6/15.
 */
@Configuration
public class SchedulerConfig {

    @Bean
    public TradeScheduler getTradeScheduler(@Qualifier(value = "schedulerFactoryBean")SchedulerFactoryBean schedulerFactoryBean) {

        List<JobTask> jobTaskList = new ArrayList<>();
        ServiceLoader<JobTask> services = ServiceLoader.load(JobTask.class);
        for (JobTask jobTask : services) {
            jobTaskList.add(jobTask);
        }

        TradeScheduler tradeScheduler = new TradeScheduler(schedulerFactoryBean.getScheduler(), jobTaskList);
        return tradeScheduler;
    }

    @Bean("schedulerFactoryBean")
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        return schedulerFactoryBean;
    }
}
