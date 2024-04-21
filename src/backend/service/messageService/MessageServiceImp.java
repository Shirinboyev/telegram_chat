package backend.service.messageService;

import backend.enums.Type;
import backend.model.chat.Chat;
import backend.model.massages.Massages;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageServiceImp implements MessageService{
    private static MessageService messageService;

    private List<Massages> messages;

    public MessageServiceImp() {
        this.messages = new ArrayList<>();
    }

    public static MessageService getInstance() {
        if (messageService == null) {
            messageService = new MessageServiceImp();
        }

        return messageService;
    }

    @Override
    public boolean add(Massages o) {
        return messages.add(o);
    }

    @Override
    public boolean delete(Massages massage) {
        return messages.remove (massage);
    }

    @Override
    public Massages get(String id) {
        for (Massages message : messages) {
            if (message.getId().equals(id)) {
                return message;
            }
        }
        return null;
    }

    @Override
    public List<Massages> getList() {
        return messages;
    }

    @Override
    public List<Massages> getMessagesOfChat(Chat chat) {
        List<Massages> messagesOfChat = new ArrayList<>();

        for (Massages message : messages) {
            if (message.getType().equals(Type.PRIVATE) && message.getToId().equals(chat.getId())) {
                messagesOfChat.add(message);
            }
        }

        return messagesOfChat;
    }

    @Override
    public List<Massages> getMessagesGroupOrChannel(String groupId) {
        List<Massages> messagesList = new ArrayList<>();
        for (Massages message : messages) {
            if (message.getToId().equals(groupId)) {
                messagesList.add(message);
            }
        }
        return messagesList;
    }

    @Override
    public int countNotReadMessages(String fromId, String toId) {

        int count = 0;
        for (Massages message : messages) {
            if (message.getToId().equals(fromId) && message.getUserId().equals(toId) && (!message.isRead())) {
                count++;

            }
        }
        return count;

    }
}
