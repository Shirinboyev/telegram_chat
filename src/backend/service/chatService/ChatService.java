package backend.service.chatService;

import backend.model.chat.Chat;
import backend.service.baseService.BaseService;

import java.util.List;

public interface ChatService extends BaseService<Chat> {

    List<Chat> getChatsOfUser(String userId);
    Chat getChatOfUser(String userId);
    boolean Exist(String userId);



}
