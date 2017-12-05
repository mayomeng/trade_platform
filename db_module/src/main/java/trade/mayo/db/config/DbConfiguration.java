package trade.mayo.db.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.MySQLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
@Configuration
@EnableConfigurationProperties(DbProperties.class)// 开启属性注入,通过@autowired注入
@ConditionalOnClass(MySQLConnection.class) // 判断这个类是否在classpath中存在
public class DbConfiguration {

    @Autowired
    private DbProperties dbProperties;

    @Bean(name="dataSource1", destroyMethod = "close", initMethod="init")
    public DataSource dataSource1() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(dbProperties.getDriverClass());
        druidDataSource.setUrl(dbProperties.getUrl());
        druidDataSource.setUsername(dbProperties.getDbUsername());
        druidDataSource.setPassword(dbProperties.getPassword());
        druidDataSource.setMaxActive(dbProperties.getMaxActive());
        druidDataSource.setInitialSize(dbProperties.getInitialSize());
        druidDataSource.setMaxWait(dbProperties.getMaxWait());
        druidDataSource.setFilters(dbProperties.getFilters());
        return druidDataSource;
    }
}
