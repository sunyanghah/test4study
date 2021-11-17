package test.stomp.config.stomp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket
 *
 * @author zhangbr
 * @date 2020-09-07
 */
@Configuration(value = "webSocketConfig333")
@EnableWebSocketMessageBroker
@EnableConfigurationProperties({RabbitStompProperties.class})
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Autowired
  private RabbitStompProperties rabbitStompProperties;

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry
      .addEndpoint("/xxv-cn002412p-websocket")
      .setAllowedOrigins("*");
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.setApplicationDestinationPrefixes("/xxv");
    registry.setUserDestinationPrefix("/user");
    registry.enableStompBrokerRelay("/topic", "/queue")
      .setRelayHost(rabbitStompProperties.getHost())
      .setRelayPort(rabbitStompProperties.getPort())
      .setVirtualHost(rabbitStompProperties.getVirtualHost())
      .setClientLogin(rabbitStompProperties.getUsername())
      .setClientPasscode(rabbitStompProperties.getPassword())
      .setSystemLogin(rabbitStompProperties.getUsername())
      .setSystemPasscode(rabbitStompProperties.getPassword());
  }

}
