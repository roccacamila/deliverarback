package spring;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
	    config.enableSimpleBroker("/topic");
	    config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("cliente").withSockJS();
		registry.addEndpoint("repartidor").withSockJS();
		registry.addEndpoint("proveedor").withSockJS();
		registry.addEndpoint("operador").withSockJS();
		registry.addEndpoint("franquicia").withSockJS();
		registry.addEndpoint("partners").withSockJS();
		registry.addEndpoint("desarrolloInterno").withSockJS();
		registry.addEndpoint("administrador").withSockJS();
	}

}
