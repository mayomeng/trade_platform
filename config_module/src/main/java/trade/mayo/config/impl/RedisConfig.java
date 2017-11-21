package trade.mayo.config.impl;

import lombok.Getter;
import lombok.Setter;
import trade.mayo.config.BaseConfig;

import java.util.List;

/**
 * Created by Administrator on 2017/10/19.
 */
@Getter
@Setter
public class RedisConfig implements BaseConfig {
    private List<String> redisHosts;
    private List<Integer> ports;
    private int maxTotal;
    private int maxIdle;
    private int maxWaitMillis;
    private int defaultTimeout;
    private int  defaultMaxRedirections;
}
