package trade.mayo.db.config;

import com.mysql.jdbc.MySQLConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.ClassUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
@Configuration
@PropertySource("classpath:db.properties")
@ConditionalOnClass(MySQLConnection.class) // 判断这个类是否在classpath中存在
public class DbConfiguration {

    @Value("${datasource.type}")
    private String datasourceType;

    @Bean(name="hengshengDataSource")
    @ConfigurationProperties(prefix = "hengsheng")
    @Primary
    public DataSource hengshengDataSource() throws SQLException, ClassNotFoundException {
        return DataSourceBuilder.create().type((Class<? extends DataSource>) ClassUtils.forName(datasourceType,
                this.getClass().getClassLoader())).build();
    }

    @Bean(name="localDataSource")
    @ConfigurationProperties(prefix = "local")
    public DataSource localDataSource() throws SQLException, ClassNotFoundException {
        return DataSourceBuilder.create().type((Class<? extends DataSource>) ClassUtils.forName(datasourceType,
                this.getClass().getClassLoader())).build();
    }
}
