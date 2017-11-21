package trade.mayo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by Administrator on 2017/6/2.
 */
//@EnableConfigurationProperties
@SpringBootApplication
@Slf4j
public class Application implements EmbeddedServletContainerCustomizer {
    public static void main(String[] args) {
        //ApplicationContextUtil.setApplicationContext();
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(8085);
    }
}
