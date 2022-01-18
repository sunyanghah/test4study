package test.study.datasources.config.datasource;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2019/7/19.
 * @author dell
 *
 * 本类用以存储当前线程下的数据源是哪个。
 * 大体思路为。通过AOP获取注解标识的数据源。存到这里供AbstractRoutingDataSource调用。
 * 结束后。清除当前存储的数据。
 *
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static List<String> dataSourceIds = new ArrayList<>();

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }

    /**
     * 判断指定数据源当前是否存在
     * 程序启动时已将所有数据源标识加入此集合
     * @param dataSourceId
     */
    public static boolean containsDataSource(String dataSourceId) {
        return dataSourceIds.contains(dataSourceId);
    }
}
