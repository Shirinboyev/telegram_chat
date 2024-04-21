package backend.service.messageService;

import backend.model.chat.Chat;
import backend.model.massages.Massages;
import backend.service.baseService.BaseService;

import java.util.List;

public interface MessageService extends BaseService<Massages> {
    List<Massages> getMessagesOfChat(Chat chat);

    List<Massages> getMessagesGroupOrChannel(String groupId);

    int countNotReadMessages(String fromId, String toId);


}
