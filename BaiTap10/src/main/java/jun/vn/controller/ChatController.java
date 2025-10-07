package jun.vn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jun.vn.model.ChatMessage;
import jun.vn.service.UserRegistry;

import java.time.LocalDateTime;

@Controller
@Slf4j
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final UserRegistry userRegistry;

    public ChatController(SimpMessagingTemplate messagingTemplate, UserRegistry userRegistry) {
        this.messagingTemplate = messagingTemplate;
        this.userRegistry = userRegistry;
    }
    @GetMapping("/")
    public String index() {
        return "chat";
    }
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        log.info("Received message from {}: {}", chatMessage.getSender(), chatMessage.getContent());
        
        // Set timestamp cho message
        chatMessage.setTimestamp(LocalDateTime.now());
        chatMessage.setType(ChatMessage.MessageType.CHAT);
        
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                              SimpMessageHeaderAccessor headerAccessor) {
        
        // Lưu username vào WebSocket session
    headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
    userRegistry.add(chatMessage.getSender());
        
        log.info("User {} joined the chat", chatMessage.getSender());
        
        chatMessage.setType(ChatMessage.MessageType.JOIN);
        chatMessage.setContent(chatMessage.getSender() + " đã tham gia cuộc trò chuyện!");
        chatMessage.setTimestamp(LocalDateTime.now());
        
        messagingTemplate.convertAndSend("/topic/users", userRegistry.all());
        return chatMessage;
    }

    @MessageMapping("/chat.sendPrivateMessage")
    public void sendPrivateMessage(@Payload ChatMessage chatMessage) {
        log.info("Sending private message from {} to {}: {}", 
                chatMessage.getSender(), chatMessage.getReceiver(), chatMessage.getContent());
        
        chatMessage.setTimestamp(LocalDateTime.now());
        chatMessage.setType(ChatMessage.MessageType.CHAT);
        
    messagingTemplate.convertAndSend(
        "/queue/private." + chatMessage.getReceiver(),
        chatMessage
    );
    }

    @GetMapping("/chat/info")
    public String getChatInfo() {
        return "WebSocket Chat Support System is running!";
    }
    @GetMapping("/chat/users")
    public java.util.Set<String> getUsers() {
        return userRegistry.all();
    }
}
