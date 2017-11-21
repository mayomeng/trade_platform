package trade.mayo.zookeeper.curator;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/19.
 */
@ConfigurationProperties(prefix = "zookeeper")
@PropertySource("classpath:zookeeper.properties")
@Primary
@Component
@Getter
@Setter
public class ZookeeperProperties {
    private String connections;
    private int sessionTimeout;
    private int connectionTimeout;

    private int retryBaseSleepTimeMs;
    private int retryMaxRetries;

    private String namespace;
    private String redisNameSpace;
    private String kafkaNameSpace;

    // 整个项目命名空间根节点的权限
    private String platformAclScheme;
    private String adminAuth;

    // 配置中心节点(目前有缓存和队列)的权限
    private String configAclScheme;
    private String catcheAuth;
    private String mqAuth;
}
