package trade.mayo.messageQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/29.
 */
@Component
public class MessageTemplate {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String topic, String key, String value) {
        kafkaTemplate.send(topic, key, value);
    }

    private MessageKey getKey(String key) {
        return new MessageKey(key);
    }

    private MessageValue getValue(String value) {
        return new MessageValue(value);
    }
}
