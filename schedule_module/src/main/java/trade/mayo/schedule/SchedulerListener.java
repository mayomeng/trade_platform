package trade.mayo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/6/16.
 */
@Component
public class SchedulerListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    TradeScheduler tradeScheduler;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
/*        try {
            tradeScheduler.startJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }*/
    }
}
