package test.study.datasources.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by dell on 2019/7/19.
 * @author dell
 *
 * AbstractRoutingDataSource提供了程序运行时动态切换数据源的方法，
 * 实现determineCurrentLookupKey方法用以返回需要使用的数据源标识
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
