package trade.mayo.controller.back;

import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import trade.mayo.config.impl.KafkaConfig;
import trade.mayo.zookeeper.configuration.ConfigurationCenter;

/**
 * Created by Administrator on 2017/6/2.
 */
@RestController
@Slf4j
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private Mapper mapper;

    @Autowired
    @Qualifier("KafkaConfigurationCenter")
    private ConfigurationCenter configurationCenter;

    @RequestMapping(value = "/kafka", method = RequestMethod.POST)
    public KafkaConfig kafkaConf(@RequestBody KafkaConfig kafkaConfig) throws Exception {
        configurationCenter.updateConfig(kafkaConfig);
        return kafkaConfig;
    }
}
