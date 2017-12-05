package trade.mayo.messageQueue.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import trade.mayo.messageQueue.MessageKey;
import trade.mayo.messageQueue.MessageValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/25.
 */
@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
@EnableKafka
//@ConditionalOnProperty(name="isEnableMq")
public class KafkaProducerConfiguration {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstraServers());
        props.put(ProducerConfig.RETRIES_CONFIG, kafkaProperties.getRetries());
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, kafkaProperties.getBatchSize());
        props.put(ProducerConfig.LINGER_MS_CONFIG, kafkaProperties.getLingerMs());
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, kafkaProperties.getBufferMemory());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, kafkaProperties.getKeySerializer());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaProperties.getValueSerializer());
        return props;
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<String, String>(producerFactory());
    }
}
