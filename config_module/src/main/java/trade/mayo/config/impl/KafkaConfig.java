package trade.mayo.config.impl;

import lombok.Getter;
import lombok.Setter;
import trade.mayo.config.BaseConfig;

/**
 * Created by Administrator on 2017/10/19.
 */
@Getter
@Setter
public class KafkaConfig implements BaseConfig {
    private String bootstraServers;

    private String acks;
    private int retries;
    private int batchSize;
    private int lingerMs;
    private long bufferMemory;
    private String keySerializer;
    private String valueSerializer;

    private String groupId;
    private boolean enableAutoCommit;
    private int autoCommitIntervalMs;
    private int sessionTimeoutMs;
    private String autoOffsetReset;
    private String keyDeserializer;
    private String valueDeserializer;
    private int consumerThreadNum;

    private String TopicNames;
}
