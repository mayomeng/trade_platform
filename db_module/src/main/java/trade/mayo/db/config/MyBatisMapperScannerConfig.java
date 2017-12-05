package trade.mayo.db.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
@Configuration
@EnableConfigurationProperties(MbProperties.class)// 开启属性注入,通过@autowired注入
public class MyBatisMapperScannerConfig {

    @Autowired
    private MbProperties mbProperties;

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //获取之前注入的beanName为sqlSessionFactory的对象
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory1");
        mapperScannerConfigurer.setBasePackage("trade.mayo.mapper");
        return mapperScannerConfigurer;
    }
}
