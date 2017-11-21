package trade.mayo.catche.redis;

import lombok.Getter;
import lombok.Setter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import trade.mayo.config.impl.RedisConfig;
import trade.mayo.zookeeper.configuration.ConfigurationCenter;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2017/6/30.
 */
//@ConfigurationProperties(prefix = "redis",locations = "classpath:redis.properties")
@ConfigurationProperties(prefix = "redis")
@PropertySource("classpath:redis.properties")
@Component
@Getter
@Setter
public class RedisProperties extends RedisConfig {

    @Autowired
    private Mapper mapper;

    @Autowired
    @Qualifier("RedisConfigurationCenter")
    private ConfigurationCenter configurationCenter;

    @PostConstruct
    public void init() throws Exception { // TODO 应该考虑当配置中心出错时，切换成从properties文件中读取相关配置
        RedisConfig redisConfig = null;
        redisConfig = (RedisConfig)configurationCenter.getConfig();
        if (redisConfig != null) {
            mapper.map(configurationCenter.getConfig(), this);
        }
    }
}
