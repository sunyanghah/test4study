package test.stomp.config.stomp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * rabbitmq stomp
 *
 * @author zhangbr
 * @date 2020-09-09
 */
@ConfigurationProperties(prefix = "xxv.rabbitmq-stomp")
@Data
public class RabbitStompProperties {

  private String host = "localhost";
  private int port = 5672;
  private String username = "guest";
  private String password = "guest";
  private String virtualHost;
}
