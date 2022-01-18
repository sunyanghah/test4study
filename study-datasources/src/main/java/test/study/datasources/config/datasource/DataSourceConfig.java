package test.study.datasources.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2019/7/19.
 * @author dell
 */
@Configuration
public class DataSourceConfig {


    @Autowired
    private DynamicDatasourceProperties dynamicDatasourceProperties;
    @Autowired
    private DefaultDatasourceProperties defaultDatasourceProperties;

    private Map<String, DataSource> dynamicDataSource = new HashMap<>();


    /**
     * 配置多数据源与默认数据源
     * @return
     */
    @Bean(name = "dynamicDataSource")
    public DataSource dataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        Map<String, DataSource> customerDataSources = getDynamicDataSource();
        Map<Object, Object> targetDataSource = new HashMap<>();
        customerDataSources.keySet().forEach(key->{
            targetDataSource.put(key, customerDataSources.get(key));
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        });

        dynamicDataSource.setTargetDataSources(targetDataSource);
        dynamicDataSource.setDefaultTargetDataSource(buildDataSource(defaultDatasourceProperties.getMaster()));
        return dynamicDataSource;
    }

    /**
     * 尤其要注意这里。本项目我们采用了baomidou的mybatis-plus插件。
     * 插件会重构造sqlSessionFactory 来 注册BaseMapper下的方法等其他东西。
     * 这里如果我们再次构造，将会冲掉插件的。导致插件提供的方法无法正常使用。
     */
//    @Bean(name = "SqlSessionFactory")
//    public SqlSessionFactory test1SqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
//            throws Exception {
//        new SqlSessionFactoryBuilder().build()
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dynamicDataSource);
////        bean.setMapperLocations(
////                new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/*.xml"));
//        return bean.getObject();
//    }


    /**
     * 获取配置的多数据源
     * @return
     */
    public Map<String, DataSource> getDynamicDataSource(){
        if(dynamicDataSource.isEmpty()){
            Map<String, Map<String, String>> props = dynamicDatasourceProperties.getDynamic();
            props.keySet().forEach(key-> dynamicDataSource.put(key, buildDataSource(props.get(key))));
        }
        return dynamicDataSource;
    }

    public DataSource getMasterDataSource(){
        return buildDataSource(defaultDatasourceProperties.getMaster());
    }


    /**
     * 构造dataSource对象
     * @param dsMap
     * @return
     */
    private DataSource buildDataSource(Map<String, String> dsMap){
//        Properties dsProps = new Properties();
//        dsProps.put("url", dsMap.get("url"));
//        dsProps.put("user", dsMap.get("username"));
//        dsProps.put("password", dsMap.get("password"));
//
//        Properties configProps = new Properties();
//        configProps.put("dataSourceClassName", dsMap.get("dataSourceClassName"));
//        configProps.put("poolName", dsMap.get("poolName"));
//        configProps.put("maximumPoolSize", dsMap.get("maximumPoolSize"));
//        configProps.put("minimumIdle", dsMap.get("minimumIdle"));
//        configProps.put("maxLifetime", dsMap.get("maxLifetime"));
//        configProps.put("connectionTimeout", dsMap.get("connectionTimeout"));
//        configProps.put("idleTimeout", dsMap.get("idleTimeout"));
//        configProps.put("dataSourceProperties", dsProps);
//
//        HikariConfig hc = new HikariConfig(configProps);
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(dsMap.get("driver-class-name"));
        ds.setJdbcUrl(dsMap.get("url"));
        ds.setUsername(dsMap.get("username"));
        ds.setPassword(dsMap.get("password"));
        return ds;
    }

    /**
     * 获取配置文件中动态数据源配置
     */
    @Configuration
    @ConfigurationProperties(prefix = "spring.datasource")
    @Data
    public static class DynamicDatasourceProperties{
        private Map<String, Map<String, String>> dynamic = new HashMap<>();
    }

    /**
     * 获取配置文件中默认的数据源配置
     */
    @Configuration
    @ConfigurationProperties(prefix = "spring.datasource")
    @Data
    public static class DefaultDatasourceProperties{
        private Map<String, String> master = new HashMap<>();
    }

}
