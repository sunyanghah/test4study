package test.study.fastdfs.config;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageClient1;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * fastdfs config.
 *
 * @author zhangbr
 * @date 2021-04-16
 */
@Configuration
@ConditionalOnClass(ClientGlobal.class)
@ConditionalOnProperty(
    prefix = "nev.fdfs",
    name = "enabled",
    havingValue = "true"
)
@EnableConfigurationProperties({FdfsConfigProperties.class})
public class FdfsConfig {

    public static final NameValuePair[] FDFS_EMPTY_META_LIST = new NameValuePair[0];

    @Bean
    public StorageClient storageClient(FdfsConfigProperties conf)
        throws MyException, IOException {
        ClientGlobal.init(conf.getConfigFile());
        return new StorageClient();
    }

    @Bean
    public StorageClient1 storageClient1(FdfsConfigProperties conf)
        throws MyException, IOException {
        ClientGlobal.init(conf.getConfigFile());
        return new StorageClient1();
    }

}
