package jun.vn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    
    public enum MessageType {
        CHAT,        // Tin nhắn thông thường
        JOIN,        // Thông báo user tham gia
        LEAVE        // Thông báo user rời khỏi
    }
    
    private MessageType type;           // Loại tin nhắn
    private String content;             // Nội dung tin nhắn
    private String sender;              // Tên người gửi
    private String receiver;            // Tên người nhận (có thể null cho group chat)
    private LocalDateTime timestamp;    // Thời gian gửi tin nhắn
    private String sessionId;          // ID phiên chat (để phân biệt các cuộc hội thoại)
    
    public ChatMessage(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.type = MessageType.CHAT;
        this.timestamp = LocalDateTime.now();
    }

    public ChatMessage(MessageType type, String sender, String content) {
        this.type = type;
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
}