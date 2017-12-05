package trade.mayo.db.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
@ConfigurationProperties
@PropertySource("classpath:db.properties")
@Component
@Getter
@Setter
public class DbProperties {
    private String driverClass;
    private String url;
    private String dbUsername;
    private String password;
    private int maxActive;
    private int initialSize;
    private int maxWait;
    private int minIdle;
    private String filters;
}
