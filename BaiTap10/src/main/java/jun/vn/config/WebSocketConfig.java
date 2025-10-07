package jun.vn.config;

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
		// Cấu hình Simple Broker với các destination prefix
		config.enableSimpleBroker("/topic", "/queue");

		// Prefix cho các message gửi từ client lên server
		config.setApplicationDestinationPrefixes("/app");

		// Prefix cho các message gửi từ server về client
		config.setUserDestinationPrefix("/user");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// Đăng ký endpoint cho kết nối WebSocket
		registry.addEndpoint("/ws").setAllowedOriginPatterns("*") // Cho phép CORS từ mọi origin (dev only)
				.withSockJS(); // Enable SockJS fallback
	}
}
