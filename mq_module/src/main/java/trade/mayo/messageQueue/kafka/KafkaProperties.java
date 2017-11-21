package trade.mayo.messageQueue.kafka;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import trade.mayo.config.impl.KafkaConfig;
import trade.mayo.zookeeper.configuration.ConfigurationCenter;
import trade.mayo.zookeeper.curator.watcher.Watcher;
import trade.mayo.zookeeper.curator.watcher.WatcherContext;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2017/8/21.
 */
@ConfigurationProperties(prefix = "kafka")
@PropertySource("classpath:kafka.properties")
@Component
public class KafkaProperties extends KafkaConfig {

    @Autowired
    private Mapper mapper;

    @Autowired
    @Qualifier("KafkaConfigurationCenter")
    private ConfigurationCenter configurationCenter;

    @Autowired
    private WatcherContext watcherContext;

    @PostConstruct
    public void init() throws Exception { // TODO 应该考虑当配置中心出错时，切换成从properties文件中读取相关配置
        KafkaConfig kafkaConfig = null;
        kafkaConfig = (KafkaConfig)configurationCenter.getConfig();
        if (kafkaConfig != null) {
            mapper.map(configurationCenter.getConfig(), this);
        }

        watcherContext.addWathcer(configurationCenter.getNameSpace(), new KafkaWatcher());
    }
}
