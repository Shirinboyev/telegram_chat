package backend.service.messageService;

import backend.model.chat.Chat;
import backend.model.massages.Message;
import backend.service.BaseService;

import java.util.List;

public interface MessageService extends BaseService<Message> {
    List<Message> getGroupMessage(String chatId, String groupId);
}
