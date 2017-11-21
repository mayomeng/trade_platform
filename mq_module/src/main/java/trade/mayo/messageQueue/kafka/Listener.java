package trade.mayo.messageQueue.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Optional;

/**
 * Created by Administrator on 2017/8/25.
 */
public class Listener {

    @KafkaListener(topics = "testtopic1")
    public void listen1(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println(Thread.currentThread().getName() + " : " + message);
        }
    }

    @KafkaListener(topics = "testtopic2")
    public void listen2(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println(Thread.currentThread().getName() + " : " + message);
        }
    }
}
