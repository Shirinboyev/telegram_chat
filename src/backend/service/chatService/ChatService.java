package backend.service.chatService;

import backend.model.chat.Chat;
import backend.service.BaseService;

public interface ChatService extends BaseService<Chat> {
    Chat getOrCreate(String id1, String id2);
}
