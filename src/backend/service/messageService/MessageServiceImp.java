package backend.service.messageService;

import backend.enums.MessageType;
import backend.enums.Type;
import backend.model.chat.Chat;
import backend.model.massages.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public List<Message> getGroupMessage(String chatId, String groupId) {
        List<Message> messageList = new ArrayList<>();
        for (Message message : messages) {
            if(Objects.equals(message.getSenderId(),groupId)&&Objects.equals(message.getType(), MessageType.GROUP)){
                if(!Objects.equals(message.getChatId(),chatId)){
                    message.setState(true);
                }
                messageList.add(message);
            }
        }
        return messageList;
    }
}
