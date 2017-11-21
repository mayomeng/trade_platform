package trade.mayo.messageQueue.kafka;

import org.springframework.stereotype.Component;
import trade.mayo.zookeeper.curator.watcher.Watcher;

/**
 * Created by Administrator on 2017/10/24.
 */
@Component
public class KafkaWatcher implements Watcher {
    @Override
    public void callbackHandler(String value) {
        System.out.println("the kafka config data : " + value);
    }
}
