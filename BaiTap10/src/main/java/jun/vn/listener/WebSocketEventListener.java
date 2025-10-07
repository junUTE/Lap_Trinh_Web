package jun.vn.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import jun.vn.model.ChatMessage;
import jun.vn.service.UserRegistry;

import java.time.LocalDateTime;

@Component
@Slf4j
public class WebSocketEventListener {

	private final SimpMessageSendingOperations messagingTemplate;
	private final UserRegistry userRegistry;

	public WebSocketEventListener(SimpMessageSendingOperations messagingTemplate, UserRegistry userRegistry) {
		this.messagingTemplate = messagingTemplate;
		this.userRegistry = userRegistry;
	}

	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		log.info("Received a new web socket connection");
	}

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

		String username = (String) headerAccessor.getSessionAttributes().get("username");

		if (username != null) {
			log.info("User {} disconnected", username);
			userRegistry.remove(username);

			// Tạo message thông báo user rời khỏi
			ChatMessage chatMessage = new ChatMessage();
			chatMessage.setType(ChatMessage.MessageType.LEAVE);
			chatMessage.setSender(username);
			chatMessage.setContent(username + " đã rời khỏi cuộc trò chuyện!");
			chatMessage.setTimestamp(LocalDateTime.now());

			// Broadcast thông báo đến tất cả users
			messagingTemplate.convertAndSend("/topic/public", chatMessage);

			// Broadcast danh sách user mới
			messagingTemplate.convertAndSend("/topic/users", userRegistry.all());
		}
	}
}
