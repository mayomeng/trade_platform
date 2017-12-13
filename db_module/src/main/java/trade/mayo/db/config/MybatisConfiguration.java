package trade.mayo.db.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
@Configuration
@PropertySource("classpath:mybatis.properties")
@AutoConfigureAfter(DbConfiguration.class)
@EnableTransactionManagement
public class MybatisConfiguration implements TransactionManagementConfigurer {

    @Value("${hengsheng.aliasesPackage}")
    private String hengshengAliasesPackage;
    @Value("${hengsheng.mapperLocations}")
    private String hengshengMapperLocations;

    @Value("${local.aliasesPackage}")
    private String localAliasesPackage;
    @Value("${local.mapperLocations}")
    private String localMapperLocations;

    @Autowired
    @Qualifier("hengshengDataSource")
    private DataSource hengshengDataSource;

    @Autowired
    @Qualifier("localDataSource")
    private DataSource localDataSource;

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {

        DataSourceTransactionManager dtm1 = new DataSourceTransactionManager(hengshengDataSource);
        DataSourceTransactionManager dtm2 = new DataSourceTransactionManager(localDataSource);

        ChainedTransactionManager ctm = new ChainedTransactionManager(dtm1, dtm2);
        return ctm;
    }


    @Bean(name = "hengshengSqlSessionFactory")
    @Primary
    public SqlSessionFactory hengshengSqlSessionFactory() throws IOException {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(hengshengDataSource);
        bean.setTypeAliasesPackage(hengshengAliasesPackage);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(hengshengMapperLocations));

        try {
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "localSqlSessionFactory")
    public SqlSessionFactory localSqlSessionFactory() throws IOException {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(localDataSource);
        bean.setTypeAliasesPackage(localAliasesPackage);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(localMapperLocations));

        try {
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean(name="hengshengSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate hengshengSqlSessionTemplate(@Qualifier("hengshengSqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    @Bean(name="localSqlSessionTemplate")
    public SqlSessionTemplate localSqlSessionTemplate(@Qualifier("localSqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
