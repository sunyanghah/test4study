package test.study.datasources3.config.datasource;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author sunYang
 * @date 2022/1/18 10:59
 */
@Configuration
@MapperScan(basePackages = {"test.study.datasources3.dao.test0105"},sqlSessionFactoryRef = "test0105SqlSessionFactory")
public class DataSourceTest0105Config {

    @Bean("test0105DataSource")
    public DataSource test0105DateSource(DataSourceTest0105Properties dataSourceTest0105Properties) throws Exception{
        //表示使用的是mysql数据库
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dataSourceTest0105Properties.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dataSourceTest0105Properties.getPassword());
        mysqlXaDataSource.setUser(dataSourceTest0105Properties.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        //Atomikos负责管理所有的事务
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("test0105DataSource");
        return xaDataSource;
    }

    @Bean("test0105SqlSessionFactory")
    public SqlSessionFactory lineSqlSessionFactory(@Qualifier("test0105DataSource") DataSource dataSource) throws Exception{
        //注意，这里引入的事MP的工厂,而不是mybatis的工厂SqlSessionFactoryBean
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //引入Mapper.xml文件的位置
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/test0105/*.xml");
        bean.setMapperLocations(resources);

        //保证MP的分页插件可用
//        Interceptor[] plugins = new Interceptor[]{paginationInterceptor};
//        bean.setPlugins(plugins);
        return bean.getObject();
    }

    @Bean(name = "test0105SqlSessionTemplate")
    public SqlSessionTemplate test0105SqlSessionTemplate(
            @Qualifier("test0105SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
