package backend.service.messageService;

import backend.enums.Type;
import backend.model.chat.Chat;
import backend.model.massages.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageServiceImp implements MessageService{
    private static MessageService messageService;

    private List<Message> messages;

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
    public boolean add(Message o) {
        return messages.add(o);
    }

    @Override
    public boolean delete(Message message) {
        return messages.remove (message);
    }

    @Override
    public Message get(String id) {
        for (Message message : messages) {
            if (message.getId().equals(id)) {
                return message;
            }
        }
        return null;
    }

    @Override
    public List<Message> getList() {
        return messages;
    }

    @Override
    public List<Message> getMessagesOfChat(Chat chat) {
        List<Message> messagesOfChat = new ArrayList<>();

        for (Message message : messages) {
            if (message.getType().equals(Type.PRIVATE) && message.getToId().equals(chat.getId())) {
                messagesOfChat.add(message);
            }
        }

        return messagesOfChat;
    }

    @Override
    public List<Message> getMessagesGroupOrChannel(String groupId) {
        List<Message> messagesList = new ArrayList<>();
        for (Message message : messages) {
            if (message.getToId().equals(groupId)) {
                messagesList.add(message);
            }
        }
        return messagesList;
    }

    @Override
    public int countNotReadMessages(String fromId, String toId) {

        int count = 0;
        for (Message message : messages) {
            if (message.getToId().equals(fromId) && message.getChatId().equals(toId) && (!message.isRead())) {
                count++;

            }
        }
        return count;

    }
}
