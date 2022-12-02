package test.study.fastdfs.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * fastdfs config.
 *
 * @author zhangbr
 * @date 2021-04-16
 */
@ConfigurationProperties("nev.fdfs")
@Data
public class FdfsConfigProperties {

    private String configFile = "config/fdfs_client.conf";
    private String nginxHost = "localhost";
    private int nginxPort = 8888;

    public String getNginxPath(){
        return nginxHost+":"+nginxPort+"/";
    }

}
