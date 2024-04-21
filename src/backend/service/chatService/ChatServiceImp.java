package backend.service.chatService;

import backend.model.chat.Chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatServiceImp implements ChatService {
    private static ChatService chatService;
    private final List<Chat> chats;

    public ChatServiceImp() {

        this.chats = new ArrayList<> ();
    }

    public static ChatService getInstance() {
        if (chatService == null) {
            chatService = new ChatServiceImp();
        }

        return chatService;
    }

    @Override
    public Chat getOrCreate(String id1,String id2) {
        for (Chat chat : chats) {
            if(Objects.equals(chat.getId1(), id1) && Objects.equals(chat.getId2(), id2)
            || Objects.equals(chat.getId1(), id2) && Objects.equals(chat.getId2(), id1)) {
                return chat;
            }
        }
        Chat chat = new Chat(id1,id2);
        chats.add(chat);
        return chat;
    }

    @Override
    public boolean add(Chat ch) {
        return chats.add (ch);
    }

    @Override
    public boolean delete(Chat chat0) {
        return chats.remove(chat0);
    }

    @Override
    public Chat get(String id) {
        for (Chat chat1 : chats) {
            if (chat1.getId().equals(id)) {

                return chat1;
            }
        }
        return null;
    }

    @Override
    public List<Chat> getList() {
        return chats;
    }
}
