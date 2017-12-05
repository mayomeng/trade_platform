package trade.mayo.db.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
@ConfigurationProperties
@PropertySource("classpath:mybatis.properties")
@Component
@Getter
@Setter
public class MbProperties {
    private String aliasesPackage;
    private String mapperLocations;
}
