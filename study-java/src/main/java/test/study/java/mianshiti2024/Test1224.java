package test.study.java.mianshiti2024;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author sun yang
 * @date 2024/12/24
 */
public class Test1224 {

    public static void main(String[] args) {
        System.out.println(getBaseUrl("http://www.baidu.com:8080"));
    }

    public static String getBaseUrl(String url) {
        try {
            // 创建URI对象
            URI uri = new URI(url);
            // 构建返回的字符串，包含协议、主机和端口
            return uri.getScheme() + "://" + uri.getHost() + ":" + uri.getPort();
        } catch (URISyntaxException e) {
            // 如果URL格式不正确，返回null或者抛出异常
            e.printStackTrace();
            return null;
        }
    }

}
